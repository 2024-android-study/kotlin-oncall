package oncall.model.date

enum class Day(val day: String, val index: Int) {
    MON("월", 1),
    TUE("화", 2),
    WED("수", 3),
    THU("목", 4),
    FRI("금", 5),
    SAT("토", 6),
    SUN("일", 0);

    companion object {
        fun dayToIndex(day: String) : Int = entries.find { it.day == day }!!.index
        fun indexToDay(index: Int) : String = entries.find { it.index == index }!!.day
    }

}