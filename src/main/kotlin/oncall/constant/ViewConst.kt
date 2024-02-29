package oncall.constant

object ViewConst {
    const val INPUT_MONTH_AND_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> "
    const val INPUT_WEEKDAY = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "
    const val INPUT_HOLIDAY = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "

    const val OUTPUT_SCHEDULE = "%d월 %d일 %s%s %s"
    const val OUTPUT_HOLIDAY = "(휴일)"
    const val OUTPUT_NOT_HOLIDAY = ""
}