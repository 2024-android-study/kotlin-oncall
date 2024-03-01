package oncall.validation

enum class MonthAndDayValidator(val message: String) {
    INVALID_FORMAT("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
    companion object {
        private const val REGEX = """^(1[0-2]|[1-9]),(일|월|화|수|목|금|토)$"""
        fun validateMonthAndDay(input: String) {
            require(REGEX.toRegex().matches(input)) { INVALID_FORMAT.message }
        }

    }
}