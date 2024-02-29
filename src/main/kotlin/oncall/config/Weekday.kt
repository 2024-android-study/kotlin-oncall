package oncall.config

enum class Weekday(val type: String) {
    Monday("월"),
    Tuesday("화"),
    Wednesday("수"),
    Thursday("목"),
    Friday("금");

    companion object {
        fun isContain(value: String): Boolean {
            for (dayOfWeek in entries) {
                if (dayOfWeek.type == value) return true
            }
            return false
        }
    }
}