package oncall.model.schedule

import oncall.model.Employee

data class WeekdaySchedule(
    val chart: List<Employee>
)