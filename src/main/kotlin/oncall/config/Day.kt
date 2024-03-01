package oncall.config

enum class Day(val day: String) {
    SUN("일"),
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토");

    fun getDayKor(): String {
        return day
    }

    companion object {
        fun findDayByString(str: String): Day? {
            for (day in Day.entries) {
                if (day.getDayKor().equals(str)) {
                    return day
                }
            }
            return null
        }

        fun findDayList(startDay: Day): List<Day> {
            val list = Day.entries.toList()
            val startIndex = list.indexOf(startDay)
            return list.subList(startIndex, list.size) + list.subList(0, startIndex)
        }

        fun isWeekend(day: Day): Boolean {
            return (day == Day.SAT || day == Day.SUN)
        }
    }
}