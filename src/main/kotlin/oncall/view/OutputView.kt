package oncall.view

import oncall.constant.ViewConst.OUTPUT_HOLIDAY
import oncall.constant.ViewConst.OUTPUT_NOT_HOLIDAY
import oncall.constant.ViewConst.OUTPUT_SCHEDULE
import oncall.model.schedule.Schedule

class OutputView {
    fun printSchedule(schedule: List<Schedule>) {
        println()
        schedule.forEach {
            println(OUTPUT_SCHEDULE.format(
                it.month,
                it.date,
                it.day,
                if (it.isHolidayMark) OUTPUT_HOLIDAY else OUTPUT_NOT_HOLIDAY,
                it.worker
                ))
        }
    }
}