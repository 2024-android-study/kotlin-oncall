package oncall

import oncall.config.Day
import oncall.config.LegalHoliday
import oncall.config.WorkDay
import oncall.view.InputView
import java.time.LocalDate
import java.time.YearMonth


class OncallApp {

    private val inputView = InputView()

    private var month: Int = 0
    private var startDay: Day = Day.MON
    lateinit var weekDayWorkers: List<String>
    lateinit var holidayWorkers: List<String>

    fun run() {
        val start = inputView.readMonthAndStartDay()
        month = start.first
        startDay = start.second
        val workers = inputView.readWorker()
        weekDayWorkers = workers.first
        holidayWorkers = workers.second
    }

    private fun emergencyScheduleList(): List<String> {
        val scheduleList = mutableListOf<String>()
        for (date in getDayInfo()) { // 비상 근무표
            //TODO: 근무자 추가
        }
        return scheduleList
    }

    private fun getDayInfo(): List<WorkDay> {
        val workDays = MutableList(monthLastDay()) { day -> WorkDay(day + 1, Day.MON, false) }
        // 해당 월의 요일 리스트
        val dayList = Day.findDayList(startDay)

        // 근무 날짜
        workDays.forEachIndexed { index, workDay ->
            val day = dayList[index % 7]
            var isHoliday = Day.isWeekend(day)
            isHoliday = LegalHoliday.isLegalHoliday(month, workDay.date)
            workDays[index] = workDay.copy(day = day, isHoliday = isHoliday)
        }
        return workDays
    }

    private fun monthLastDay(): Int {
        // 일반화
        val date = LocalDate.parse("2023-%02d-01".format(month))
        val yearMonth = YearMonth.from(date)
        return yearMonth.lengthOfMonth()
    }
}