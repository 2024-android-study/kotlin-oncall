package oncall.model.schedule

import oncall.model.Employee

data class WeekendSchedule(
    val chart: List<Employee>
)
