package oncall.config

enum class LegalHoliday(val date: String, val title: String) {
    NEW_YEAR("1/1", "신정"),
    INDEPENDENCE_MOVEMENT("3/1", "삼일절"),
    CHILDREN("5/5", "어린이날"),
    MEMORIAL("6/6", "현충일"),
    NATIONAL_LIBERATION("8/15", "광복절"),
    NATIONAL_FOUNDATION("10/3", "개천절"),
    HANGUL_PROCLAMATION("10/9", "한글날"),
    CHRISTMAS("12/25", "성탄절");

    companion object {

        private fun getHolidayDate(holiday: LegalHoliday): Pair<Int, Int> {
            val split = holiday.date.split("/")
            return Pair(split[0].toInt(), split[1].toInt())
        }

        fun isLegalHoliday(month: Int, date: Int): Boolean {
            val holidays = LegalHoliday.entries
            val holidayDate = mutableListOf<Pair<Int, Int>>()
            holidays.forEach {
                holidayDate.add(getHolidayDate(it))
            }
            if (holidayDate.contains(Pair(month, date))) return true
            return false
        }
    }
}