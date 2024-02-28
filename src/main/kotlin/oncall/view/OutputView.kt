package oncall.view

import oncall.constants.ViewConstant
import oncall.domain.*

class OutputView {

    fun printWorkOrders(date: WorkDate, workers: List<Worker>) {
        var dayIndex: Int = DayOfWeek.days.indexOf(date.dayOfWeek)

        for (day in 1..workers.size) {
            val curDay = DayOfWeek.days[dayIndex]
            val holiday = if (Holiday.isHoliday(date.month, day)) ViewConstant.HOLIDAY else ""

            println(ViewConstant.DAY.format(date.month, day, curDay, holiday, workers[day - 1].name))

            dayIndex = (dayIndex + 1) % 7
        }
    }
}