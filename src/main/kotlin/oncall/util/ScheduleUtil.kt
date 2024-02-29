package oncall.util

import oncall.model.Employee
import oncall.model.schedule.WeekdaySchedule
import oncall.model.schedule.WeekendSchedule

object ScheduleUtil {

    fun assignHoliday(
        weekendSchedule: WeekendSchedule,
        chart: MutableList<Pair<Employee, String>>,
        dayOfWeek: String,
    ) {
        chart.add(Pair(weekendSchedule.chart.first, dayOfWeek))
        val pop = weekendSchedule.chart.pop()
        weekendSchedule.chart.addLast(pop)
    }

    fun assignWeekday(
        weekdaySchedule: WeekdaySchedule,
        chart: MutableList<Pair<Employee, String>>,
        dayOfWeek: String
    ) {
        chart.add(Pair(weekdaySchedule.chart.first, dayOfWeek))
        val pop = weekdaySchedule.chart.pop()
        weekdaySchedule.chart.addLast(pop)
    }

    fun assignWeekend(
        weekendSchedule: WeekendSchedule,
        chart: MutableList<Pair<Employee, String>>,
        dayOfWeek: String
    ) {
        chart.add(Pair(weekendSchedule.chart.first, dayOfWeek))
        val pop = weekendSchedule.chart.pop()
        weekendSchedule.chart.addLast(pop)
    }
}