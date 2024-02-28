package oncall.validation

import oncall.model.WorkOrder

enum class WorkerValidator(val message: String) {
    OUT_OF_RANGE("[ERROR] 최소 5명, 최대 35명의 근무자가 필요합니다. 다시 입력해 주세요."),
    DUPLICATE("[ERROR] 중복된 닉네임이 존재합니다. 다시 입력해 주세요."),
    TOO_LONG("[ERROR] 닉네임은 최대 5글자 입니다. 다시 입력해 주세요."),
    NOT_SAME_WORKERS("[ERROR] 주중, 주말 근무자가 다릅니다. 다시 입력해주세요.");

    companion object {
        private const val MIN_WORKER = 5
        private const val MAX_WORKER = 35
        private const val MAX_NICKNAME_LENGTH = 5
        fun validateWorker(input: List<String>) {
            val error = when {
                input.size !in MIN_WORKER..MAX_WORKER -> OUT_OF_RANGE
                input.toSet().size != input.size -> DUPLICATE
                input.all { it.length > MAX_NICKNAME_LENGTH } -> TOO_LONG
                else -> return
            }
            throw IllegalArgumentException(error.message)
        }

        fun isSameWorkers(order: WorkOrder) {
            require(order.weekday.toSet() == order.weekend.toSet())
            { NOT_SAME_WORKERS }
        }

    }
}