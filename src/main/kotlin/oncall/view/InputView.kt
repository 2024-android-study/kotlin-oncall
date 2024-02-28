package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.model.WorkOrder
import oncall.validation.MonthAndDayValidator
import oncall.validation.WorkerValidator

class InputView {
    fun getMonthAndDay(): List<String> {
        while(true) {
            try {
                print(MONTH_AND_DAY)
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
                print(WEEKDAY)
                order.weekday = getWeekdayWorker()
                print(WEEKEND)
                order.weekend = getWeekendWorker()
                WorkerValidator.isSameWorkers(order)
                return order
            } catch (e: IllegalArgumentException) {
                println(e)
            }

        }
    }
    private fun getWeekdayWorker(): List<String> {
        print(WEEKDAY)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input
    }

    private fun getWeekendWorker(): List<String> {
        print(WEEKEND)
        val input = Console.readLine().split(",")
        WorkerValidator.validateWorker(input)
        return input
    }

    companion object {
        const val MONTH_AND_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val WEEKDAY = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val WEEKEND = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
    }
}