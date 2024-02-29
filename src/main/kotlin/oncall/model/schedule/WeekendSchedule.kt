package oncall.model.schedule

import oncall.model.Employee
import java.util.Deque

data class WeekendSchedule(
    val chart: Deque<Employee>
)
