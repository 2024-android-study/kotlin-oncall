package oncall.model

data class Schedule(
    val date: Int,
    val day: String,
    val isHoliday: Boolean,
    val worker: String
)
