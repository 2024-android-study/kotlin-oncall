package oncall.domain

enum class DayOfWeek(val day: String) {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    companion object {
        val days: List<String> = entries.map { it.day }

        fun isWeekend(day: String): Boolean {
            return day == SATURDAY.day || day == SUNDAY.day
        }
    }
}