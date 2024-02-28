package oncall.validator

import oncall.constants.NumConstant
import oncall.domain.DayOfWeek

enum class DateValidator(val message: String) {
    EMPTY("[ERROR] 날짜를 입력하지 않았습니다. 다시 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백이 포함되어 있습니다. 다시 입력해 주세요."),
    NOT_NUMBER("[ERROR] 숫자가 아닙니다. 다시 입력해 주세요."),
    INVALID_DATE("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    companion object {
        fun validateDate(input: String) {
            val error = when {
                input.isEmpty() -> EMPTY
                input.contains(" ") -> INCLUDE_BLANK
                input.contains(",").not() -> INVALID_DATE
                input.split(",")[0].matches(Regex("^\\d+$")).not() -> NOT_NUMBER
                input.split(",")[0].toInt() !in (NumConstant.MONTH_FIRST..NumConstant.MONTH_LAST) -> INVALID_DATE
                input.split(",")[1] !in DayOfWeek.DAYS.day -> INVALID_DATE
                else -> return
            }

            throw IllegalArgumentException(error.message)
        }
    }
}