package oncall.model.schedule

import oncall.model.Employee
import java.util.Deque

data class WeekdaySchedule(
    val chart: Deque<Employee>
)