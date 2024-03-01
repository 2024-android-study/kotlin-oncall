package oncall

import oncall.view.InputView

class OncallApp {
    private val inputView = InputView()

    fun run() {
        val start = inputView.readMonthAndStartDay()
        val weekDayWorker = inputView.readWeekDayWorker()
    }
}