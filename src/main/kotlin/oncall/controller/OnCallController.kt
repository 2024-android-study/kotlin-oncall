package oncall.controller

import oncall.model.date.DateInfo
import oncall.model.date.Day
import oncall.model.date.DaysInMonth
import oncall.model.date.HolidayChecker
import oncall.model.schedule.Schedule
import oncall.model.schedule.WorkOrder
import oncall.view.InputView
import oncall.view.OutputView
import java.util.*

class OnCallController {
    private val input = InputView()
    private val output = OutputView()

    private var weekdayWorkerIndex = 0
    private var holidayWorkerIndex = 0

    fun run() {
        val (month, startDay) = input.getMonthAndDay()
        val monthInt = month.toInt()
        val order = input.getWorker()

        val schedules = createSchedules(monthInt, Day.dayToIndex(startDay), order)
        output.printSchedule(schedules)
    }

    private fun createSchedules(month: Int, startDayIndex: Int, order: WorkOrder): MutableList<Schedule> {
        val schedules = mutableListOf<Schedule>()
        var lastWorker: String? = null
        val totalDays = DaysInMonth.getDaysInMonth(month)
        var currentDayIndex = startDayIndex

        (1..totalDays).forEach { date ->
            val dayOfWeek = Day.indexToDay(currentDayIndex)
            val isHoliday = dayOfWeek in WEEKEND || HolidayChecker.isHoliday(DateInfo(month, date))
            val workerList = if (isHoliday) order.holiday else order.weekday
            val workerIndex = getNextWorkerIndex(workerList, isHoliday)
            if (workerList[workerIndex] == lastWorker) { swapWorkers(workerList, workerIndex, isHoliday) }

            val isHolidayMark = dayOfWeek !in WEEKEND && HolidayChecker.isHoliday(DateInfo(month, date))

            val schedule = Schedule(month, date, dayOfWeek, isHolidayMark, workerList[workerIndex])
            schedules.add(schedule)

            lastWorker = schedule.worker
            currentDayIndex = (currentDayIndex + 1) % 7
        }

        return schedules
    }

    private fun getNextWorkerIndex(workerList: List<String>, isHoliday: Boolean): Int {
        val currentIndex = if (isHoliday) holidayWorkerIndex else weekdayWorkerIndex
        // 인덱스 업데이트
        if (isHoliday) {
            holidayWorkerIndex = (holidayWorkerIndex + 1) % workerList.size
        } else {
            weekdayWorkerIndex = (weekdayWorkerIndex + 1) % workerList.size
        }
        return currentIndex % workerList.size
    }

    private fun swapWorkers(workerList: MutableList<String>, currentIndex: Int, isWeekendOrHoliday: Boolean) {
        val nextIndex = (currentIndex + 1) % workerList.size
        if (isWeekendOrHoliday) {
            holidayWorkerIndex = nextIndex
        } else {
            weekdayWorkerIndex = nextIndex
        }

        Collections.swap(workerList, currentIndex, nextIndex)
    }

    companion object {
        private val WEEKEND = listOf("토", "일")
    }
}