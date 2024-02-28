package oncall.model

data class WorkOrder(
    var weekday: List<String>,
    var weekend: List<String>
)
