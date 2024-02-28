package oncall.domain

enum class Month(val month: Int) {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    companion object {
        fun getMonthEndDay(month: Int): Int {
            return when (month) {
                in listOf(JANUARY.month, MARCH.month, MAY.month, JULY.month, AUGUST.month, OCTOBER.month, DECEMBER.month) -> 31
                in listOf(APRIL.month, JUNE.month, SEPTEMBER.month, NOVEMBER.month) -> 30
                FEBRUARY.month -> 28
                else -> 0
            }
        }
    }
}