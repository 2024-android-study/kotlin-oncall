package oncall.controller

import oncall.domain.*
import oncall.view.InputView
import oncall.view.OutputView

class OnCallController {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        val date = inputView.readDate()
        val workers = inputView.readWorker()

        val weekdayWorkers = workers.first
        val dayOffWorkers = workers.second

        val workOrder = WorkOrder(date, weekdayWorkers, dayOffWorkers)

        workOrder.assignWork()

        outputView.printWorkOrders(date, workOrder.getWorkerOrder())
    }

}