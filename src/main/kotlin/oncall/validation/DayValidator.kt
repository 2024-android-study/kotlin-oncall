package oncall.validation

import oncall.config.Day
import oncall.service.InputConverter

enum class DayValidator(val error: String) {
    INPUT_EMPTY("[ERROR] 값을 입력해 주세요."),
    INVALID_ARGUMENT_RANGE("[ERROR] 인자의 개수는 2개여야 합니다."),
    INVALID_MONTH("[ERROR] 월은 1에서 12 사이의 숫자여야 합니다."),
    INVALID_DAY("[ERROR] 시작 요일은 일~토의 요일 중 하나여야 합니다.");

    companion object {
        fun validateDay(input: String) {
            val strs = InputConverter.splitByComma(input)
            val errorMsg = when {
                input.isEmpty() -> INPUT_EMPTY
                strs.size !in 1..2 -> INVALID_ARGUMENT_RANGE
                strs[0].toInt() !in (1..12) -> INVALID_MONTH
                Day.findDayByString(strs[1]) == null -> INVALID_DAY
                else -> return
            }
            throw IllegalArgumentException(errorMsg.error)
        }
    }
}