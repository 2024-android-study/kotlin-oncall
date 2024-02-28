package oncall.view

import oncall.constant.ViewConst
import oncall.constant.ViewConst.OUTPUT_HOLIDAY
import oncall.constant.ViewConst.OUTPUT_NOT_HOLIDAY
import oncall.constant.ViewConst.OUTPUT_SCHEDULE
import oncall.model.Schedule

class OutputView {
    fun printSchedule(month: Int, schedule: List<Schedule>) {
        println()
        schedule.map {
            println(OUTPUT_SCHEDULE.format(
                month,
                it.date,
                it.day,
                if (it.isHoliday) OUTPUT_HOLIDAY else OUTPUT_NOT_HOLIDAY,
                it.worker
                ))
        }

    }
}