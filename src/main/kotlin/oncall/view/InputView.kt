package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constant.ViewConst.INPUT_MONTH_AND_DAY
import oncall.constant.ViewConst.INPUT_WEEKDAY
import oncall.constant.ViewConst.INPUT_WEEKEND
import oncall.model.WorkOrder
import oncall.validation.MonthAndDayValidator
import oncall.validation.WorkerValidator

class InputView {
    fun getMonthAndDay(): List<String> {
        while(true) {
            try {
                print(INPUT_MONTH_AND_DAY)
                val input = Console.readLine()
                MonthAndDayValidator.validateMonthAndDay(input)
                return input.split(",")
            } catch (e: IllegalArgumentException) {
                println(e)
            }

        }

    }

    fun getWorker(): WorkOrder {
        val order = WorkOrder(listOf(), listOf())
        while(true) {
            try {
                print(INPUT_WEEKDAY)
                order.weekday = getWeekdayWorker()
                print(INPUT_WEEKEND)
                order.weekend = getWeekendWorker()
                WorkerValidator.isSameWorkers(order)
                return order
            } catch (e: IllegalArgumentException) {
                println(e)
            }

        }
    }
    private fun getWeekdayWorker(): List<String> {
        print(INPUT_WEEKDAY)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input
    }

    private fun getWeekendWorker(): List<String> {
        print(INPUT_WEEKEND)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input
    }


}