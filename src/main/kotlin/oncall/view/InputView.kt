package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.config.Day
import oncall.service.InputConverter
import oncall.validation.DayValidator
import oncall.validation.WorkerValidator

class InputView {
    fun readMonthAndStartDay(): Pair<Int, Day> {
        while (true) {
            try {
                print(DATE_PROMPT)
                val input = Console.readLine()
                DayValidator.validateDay(input)
                return InputConverter.findMonthAndDay(input)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    fun readWorker(): Pair<List<String>, List<String>> {
        while (true) {
            try {
                val weekDayWorkers = readWeekDayWorker()
                val holidayWorkers = readHolidayWorker()
                WorkerValidator.validateWeekdayAndHolidayWorker(weekDayWorkers, holidayWorkers)
                println()
                return Pair(weekDayWorkers, holidayWorkers)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun readWeekDayWorker(): List<String> {
        print(WEEKDAY_PROMPT)
        val input = Console.readLine()
        WorkerValidator.validateWorker(input)
        return InputConverter.splitByComma(input)
    }

    private fun readHolidayWorker(): List<String> {
        print(HOLIDAY_PROMPT)
        val input = Console.readLine()
        WorkerValidator.validateWorker(input)
        return InputConverter.splitByComma(input)
    }

    companion object {
        const val DATE_PROMPT = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val WEEKDAY_PROMPT = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val HOLIDAY_PROMPT = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
    }
}