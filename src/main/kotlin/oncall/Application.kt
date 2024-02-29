package oncall

import oncall.view.InputView
import oncall.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    OnCallApp(inputView, outputView).run()
}
