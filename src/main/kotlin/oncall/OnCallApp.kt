package oncall

import oncall.model.Employee
import oncall.model.schedule.WeekdaySchedule
import oncall.model.schedule.WeekendSchedule
import oncall.model.schedule.WorkSchedule
import oncall.util.DateUtil
import oncall.view.InputView
import oncall.view.OutputView
import java.util.Deque
import java.util.LinkedList

class OnCallApp(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val workSchedule = createWorkSchedule()
        val schedule = createSchedule()
        workSchedule.generate(schedule.first, schedule.second)
        runResult(workSchedule)
    }

    private fun createWorkSchedule(): WorkSchedule {
        while (true) {
            try {
                val monthAndDayOfWeek = inputView.readMonthAndStartDayOfWeek()
                val month = monthAndDayOfWeek.first().toInt()
                val dayOfWeek = monthAndDayOfWeek.last()
                val maxDay = DateUtil.getMaxDayInMonth(month)

                return WorkSchedule(month, maxDay, dayOfWeek)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }

    private fun createSchedule(): Pair<WeekdaySchedule, WeekendSchedule> {
        while (true) {
            try {
                val weekdayWorkerNames: Deque<Employee> = LinkedList()
                selectWorker(inputView.readWeekdayWorkerName(), weekdayWorkerNames)
                val weekdaySchedule = WeekdaySchedule(weekdayWorkerNames)

                val weekendWorkerNames: Deque<Employee> = LinkedList()
                selectWorker(inputView.readWeekendWorkerName(), weekendWorkerNames)
                val weekendSchedule = WeekendSchedule(weekendWorkerNames)
                return Pair(weekdaySchedule, weekendSchedule)
            } catch (e: Exception) {
                println(e)
            }
        }
    }

    private fun selectWorker(input: List<String>, workerNames: Deque<Employee>) {
        input.forEach { name ->
            workerNames.push(Employee(name))
        }
    }

    private fun runResult(workSchedule: WorkSchedule) = outputView.printMonthSchedule(workSchedule)
}