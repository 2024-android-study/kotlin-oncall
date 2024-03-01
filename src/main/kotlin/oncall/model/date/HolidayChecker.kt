package oncall.model.date

object HolidayChecker {
    private val holidays = listOf(
        DateInfo(1,1),
        DateInfo(3,1),
        DateInfo(5,5),
        DateInfo(6,6),
        DateInfo(8,15),
        DateInfo(10,3),
        DateInfo(10,9),
        DateInfo(12,25)
    )

    fun isHoliday(date: DateInfo): Boolean {
        return holidays.contains(date)
    }
}