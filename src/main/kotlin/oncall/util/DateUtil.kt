package oncall.util

import oncall.config.Weekday
import oncall.config.Weekend
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

object DateUtil {

    fun getMaxDayInMonth(month: Int): Int {
        val yearMonth = YearMonth.of(2024, month)
        return yearMonth.lengthOfMonth()
    }

    fun nextDateOfWeek(dayOfWeek: String): String {
        return when (dayOfWeek) {
            Weekday.Monday.type -> Weekday.Tuesday.type
            Weekday.Tuesday.type -> Weekday.Wednesday.type
            Weekday.Wednesday.type -> Weekday.Thursday.type
            Weekday.Thursday.type -> Weekday.Friday.type
            Weekday.Friday.type -> Weekend.Saturday.type
            Weekend.Saturday.type -> Weekend.Sunday.type
            else -> Weekday.Monday.type
        }
    }
}