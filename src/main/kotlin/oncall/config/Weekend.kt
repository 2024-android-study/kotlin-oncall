package oncall.config

enum class Weekend(val type: String) {
    Saturday("토"),
    Sunday("일");

    companion object {
        fun isContain(value: String): Boolean {
            for (dayOfWeek in Weekday.entries) {
                if (dayOfWeek.type == value) return true
            }
            return false
        }
    }
}