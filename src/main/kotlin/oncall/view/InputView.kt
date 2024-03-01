package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.config.Day
import oncall.service.InputConverter
import oncall.validation.DayValidator

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

    companion object {
        const val DATE_PROMPT = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
    }
}