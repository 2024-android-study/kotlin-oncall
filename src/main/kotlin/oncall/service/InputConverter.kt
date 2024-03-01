package oncall.service

import oncall.config.Day

object InputConverter {
    private val DELIMINATOR = ","

    fun splitByComma(str: String): List<String> {
        return str.split(DELIMINATOR)
    }

    fun findMonthAndDay(input: String): Pair<Int, Day> {
        return convertListToPair(splitByComma(input))
    }

    private fun convertListToPair(strs: List<String>): Pair<Int, Day> {
        return Pair(strs[0].toInt(), Day.findDayByString(strs[1])!!)
    }
}