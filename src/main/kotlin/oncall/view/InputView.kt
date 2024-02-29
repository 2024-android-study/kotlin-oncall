package oncall.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readMonthAndStartDayOfWeek(): List<String> {
        print(INPUT_MONTH_AND_START_DAY_OF_WEEK)
        val input = Console.readLine()
        return input.split(",")
    }

    fun readWeekdayWorkerName(): List<String> {
        print(INPUT_WEEKDAY_WORKER_NAME)
        val input = Console.readLine()
        return input.split(",")
    }

    fun readWeekendWorkerName(): List<String> {
        print(INPUT_WEEKEND_WORKER_NAME)
        val input = Console.readLine()
        println()
        return input.split(",")
    }

    companion object {
        private const val INPUT_MONTH_AND_START_DAY_OF_WEEK = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
        private const val INPUT_WEEKDAY_WORKER_NAME = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
        private const val INPUT_WEEKEND_WORKER_NAME = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
    }
}