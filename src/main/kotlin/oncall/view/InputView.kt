package oncall.view

import camp.nextstep.edu.missionutils.Console
import oncall.constants.ViewConstant
import oncall.domain.WorkDate
import oncall.domain.Worker
import oncall.validator.DateValidator
import oncall.validator.WorkerValidator

class InputView {

    private val dateValidator = DateValidator
    private val workerValidator = WorkerValidator

    fun readDate(): WorkDate {
        while (true) {
            print(ViewConstant.READ_MONTH_DAY)

            try {
                val input = Console.readLine()

                dateValidator.validateDate(input)

                val date = input.split(",")
                return WorkDate(date[0].toInt(), date[1])
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWorker(): Pair<List<Worker>, List<Worker>> {
        while (true) {
            try {
                val weekdayWorker = readWeekDayName()
                val dayOffWorker = readDayOffName()

                return Pair(weekdayWorker, dayOffWorker)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readWeekDayName(): List<Worker> {
        print(ViewConstant.READ_WEEK_DAY)

        val input = Console.readLine()

        workerValidator.validateForm(input)

        val nameList = input.split(",")
        workerValidator.validateName(nameList)

        return nameList.map {
            Worker(it)
        }
    }

    private fun readDayOffName(): List<Worker> {
        print(ViewConstant.READ_DAY_OFF)

        val input = Console.readLine()

        workerValidator.validateForm(input)

        val nameList = input.split(",")
        workerValidator.validateName(nameList)

        return nameList.map {
            Worker(it)
        }
    }

}