package oncall.validation

import oncall.service.InputConverter

enum class WorkerValidator(val error: String) {
    INPUT_EMPTY("[ERROR] 값을 입력해 주세요."),
    INVALID_RANGE("[ERROR] 근무자는 5명 이상 35명 이하여야 합니다."),
    INVALID_NICKNAME("[ERROR] 유효하지 않은 닉네임입니다."),
    WORKER_DUPLICATE("[ERROR] 같은 순번에 중복된 닉네임이 들어갈 수 없습니다."),
    WORKER_NOT_MATCH("[ERROR] 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다.");

    companion object {
        private const val WORKER_MIN = 5
        private const val WORKER_MAX = 35

        fun validateWorker(input: String) {
            val workers = InputConverter.splitByComma(input)
            val errorMsg = when {
                input.isEmpty() -> INPUT_EMPTY
                workers.size !in WORKER_MIN..WORKER_MAX -> INVALID_RANGE
                workers.size != workers.toSet().size -> WORKER_DUPLICATE
                !workers.all { checkNicknameValidation(it) } -> INVALID_NICKNAME
                else -> return
            }
            throw IllegalArgumentException(errorMsg.error)
        }

        fun validateWeekdayAndHolidayWorker(weekDayWorker: List<String>, holidayWorker: List<String>) {
            require (weekDayWorker != holidayWorker) { WORKER_NOT_MATCH }
        }

        private fun checkNicknameValidation(nickName: String): Boolean {
            return nickName.matches(Regex("^[\\s가-힣a-zA-Z]{1,5}$"))
        }
    }
}