package oncall.model

class Employee(
    private val name: String,
) {

    fun isWorkingContinuouslyWeekdays(date: Int, nextDate: Int): Boolean {
        if (date + 1 == nextDate) return true
        return false
    }
}