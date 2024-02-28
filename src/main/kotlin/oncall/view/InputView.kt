package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.validation.InputValidator

class InputView {
    private val inputValidator = InputValidator()
    fun getMonthAndDay() {
        print(MONTH_AND_DAY)
        val input = Console.readLine()
        inputValidator.validateMonthAndDay(input)
    }

    fun getWeekday() {
        print(WEEKDAY)
        val input = Console.readLine()
        inputValidator.validateWeekday(input)
    }

    fun getWeekend() {
        print(WEEKEND)
        val input = Console.readLine()
        inputValidator.validateWeekend(input)
    }

    companion object {
        const val MONTH_AND_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        const val WEEKDAY = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        const val WEEKEND = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
    }
}