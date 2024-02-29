package oncall.view

import oncall.model.schedule.WorkSchedule

class OutputView {

    fun printMonthSchedule(workSchedule: WorkSchedule) {
        for ((i, pair) in workSchedule.chart.withIndex()) {
            println(VIEW_SCHEDULE_EACH_DATE_WORKER.format(workSchedule.month, i, pair.second, pair.first.name))
        }
    }

    companion object {
        private const val VIEW_SCHEDULE_EACH_DATE_WORKER = "%d월 %d일 %s %s"
    }
}