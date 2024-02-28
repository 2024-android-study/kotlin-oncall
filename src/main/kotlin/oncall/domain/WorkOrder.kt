package oncall.domain

class WorkOrder(
    private val date: WorkDate,
    private val weekdayWorkers: List<Worker>,
    private val dayOffWorkers: List<Worker>
) {

    private val assignedWorkers = mutableListOf<Worker>()

    fun getWorkerOrder(): List<Worker> {
        return assignedWorkers
    }

    fun assignWork() {
        val monthEnd = Month.getMonthEndDay(date.month)

        val repeatWeekdayWorkers = List(monthEnd) { weekdayWorkers }.flatten().toMutableList()
        val repeatDayOffWorkers = List(monthEnd) { dayOffWorkers }.flatten().toMutableList()

        var dayIndex = DayOfWeek.days.indexOf(date.dayOfWeek)

        for (day in 1..monthEnd) {
            val curDay = DayOfWeek.days[dayIndex]

            if (isDayOff(day, curDay)) {
                checkWorker(repeatDayOffWorkers)
                assignedWorkers.add(repeatDayOffWorkers.removeFirst())
            } else {
                checkWorker(repeatWeekdayWorkers)
                assignedWorkers.add(repeatWeekdayWorkers.removeFirst())
            }

            dayIndex = (dayIndex + 1) % 7
        }
    }

    private fun checkWorker(workers: MutableList<Worker>) {
        if (assignedWorkers.isNotEmpty() && workers.size > 2 && workers.first() == this.assignedWorkers.last()) {
            switchWorker(workers)
        }
    }

    private fun switchWorker(workers: MutableList<Worker>) {
        val temp = workers[0]
        workers[0] = workers[1]
        workers[1] = temp
    }

    private fun isDayOff(day: Int, dayOfWeek: String): Boolean {
        return Holiday.isHoliday(date.month, day) || DayOfWeek.isWeekend(dayOfWeek)
    }

}
