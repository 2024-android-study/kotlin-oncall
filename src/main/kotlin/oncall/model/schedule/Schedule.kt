package oncall.model.schedule

data class Schedule(
    val month: Int,
    val date: Int,
    val day: String,
    val isHolidayMark: Boolean,
    val worker: String
)
