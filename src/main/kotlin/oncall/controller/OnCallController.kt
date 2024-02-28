package oncall.controller

import oncall.view.InputView
import oncall.view.OutputView

class OnCallController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val workDate = inputView.readDate()
        val workers = inputView.readWorker()

        val weekdayWorkers = workers.first
        val dayOffWorkers = workers.second


    }

}