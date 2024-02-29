package oncall.config

enum class Holiday(val month: Int, val date: Int) {
    January(1, 1),
    March(3, 3),
    May(5, 5),
    June(6,6),
    August(8, 15),
    OctoberOne(10, 3),
    OctoberTwo(10, 9),
    December(12, 25);

    companion object {
        fun isContain(month: Int, date: Int): Boolean {
            val result = entries.find { it.month == month && it.date == date }
            return result != null
        }
    }
}