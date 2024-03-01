package oncall.config

import java.time.DayOfWeek

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
    }
}