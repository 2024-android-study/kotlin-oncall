package oncall.validator

import oncall.constants.NumConstant

enum class WorkerValidator(val message: String) {
    EMPTY("[ERROR] 이름을 입력하지 않았습니다. 다시 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    INVALID_NAME("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    companion object {
        fun validateForm(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY
                input.contains(" ") -> INCLUDE_BLANK
                input.contains(",").not() -> INVALID_NAME
                input.contains(",,") -> INVALID_NAME
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }

        fun validateName(nameList: List<String>) {
            val error = when {
                !nameList.all { it.length <= 5 } -> INVALID_NAME
                nameList.size != nameList.toSet().size -> INVALID_NAME
                nameList.size !in (NumConstant.MIN_WORKER_CNT .. NumConstant.MAX_WORKER_CNT) -> INVALID_NAME
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }
    }
}