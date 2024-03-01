package oncall.model.schedule

data class WorkOrder(
    var weekday: MutableList<String>,
    var holiday: MutableList<String>
)
