package oncall

import oncall.view.InputView

class OncallApp {

    private val inputView = InputView()
    lateinit var weekDayWorkers: List<String>
    lateinit var holidayWorkers: List<String>

    fun run() {
        val start = inputView.readMonthAndStartDay()
        val workers = inputView.readWorker()
        weekDayWorkers = workers.first
        holidayWorkers = workers.second
    }
}