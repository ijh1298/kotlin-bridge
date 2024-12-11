package bridge.controller

import bridge.validator.InputValidator
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    private var bridgeLength = 3
    private var gameAgain = false

    fun run() {
        inputBridgeLength()
    }

    private fun inputBridgeLength() {
        var rawLength = ""
        loopUntilValid {
            rawLength = inputView.readBridgeSize()
            InputValidator.validateBridgeLength(rawLength)
        }
        bridgeLength = rawLength.toInt()
    }

    // 반복 입력받는 로직
    private fun <T> loopUntilValid(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message + '\n')
            }
        }
    }
}