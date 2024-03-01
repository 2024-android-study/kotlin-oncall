package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constant.ViewConst.INPUT_HOLIDAY
import oncall.constant.ViewConst.INPUT_MONTH_AND_DAY
import oncall.constant.ViewConst.INPUT_WEEKDAY
import oncall.model.schedule.WorkOrder
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
                println(e.message)
            }

        }

    }

    fun getWorker(): WorkOrder {
        val order = WorkOrder(mutableListOf(), mutableListOf())
        while(true) {
            try {
                order.weekday = getWeekdayWorker()
                order.holiday = getHolidayWorker()
                WorkerValidator.isSameWorkers(order)
                return order
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }

        }
    }
    private fun getWeekdayWorker(): MutableList<String> {
        print(INPUT_WEEKDAY)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input.toMutableList()
    }

    private fun getHolidayWorker(): MutableList<String> {
        print(INPUT_HOLIDAY)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input.toMutableList()
    }


}