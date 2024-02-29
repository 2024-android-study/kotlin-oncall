package oncall.model.schedule

import oncall.config.Holiday
import oncall.config.Weekday
import oncall.config.Weekend
import oncall.model.Employee
import oncall.util.DateUtil
import oncall.util.ScheduleUtil

class WorkSchedule(
    val month: Int,
    private val maxDay: Int,
    private val firstDayOfWeek: String
) {
    val chart = mutableListOf<Pair<Employee, String>>()

    fun generate(
        weekdaySchedule: WeekdaySchedule,
        weekendSchedule: WeekendSchedule
    ) {
        var date = 1
        var dayOfWeek = firstDayOfWeek

        while (date <= maxDay) {
            when {
                Holiday.isContain(month, date) -> { ScheduleUtil.assignHoliday(weekendSchedule, chart, dayOfWeek) }
                Weekday.isContain(dayOfWeek) -> { ScheduleUtil.assignWeekday(weekdaySchedule, chart, dayOfWeek) }
                Weekend.isContain(dayOfWeek) -> ScheduleUtil.assignWeekend(weekendSchedule, chart, dayOfWeek)
            }
            dayOfWeek = DateUtil.nextDateOfWeek(dayOfWeek)
            date++
        }
    }
}