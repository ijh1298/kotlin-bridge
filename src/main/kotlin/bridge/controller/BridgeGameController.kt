package bridge.controller

import bridge.BridgeGame
import bridge.BridgeMaker
import bridge.utils.BridgeRandomNumberGenerator
import bridge.validator.InputValidator
import bridge.view.InputView
import bridge.view.OutputView

class BridgeGameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val bridgeMaker: BridgeMaker = BridgeMaker(BridgeRandomNumberGenerator())
) {
    private lateinit var game: BridgeGame
    private lateinit var bridge: List<String>
    private var bridgeLength = 3
    private var gameAgain = false
    private var currentTurn = 0

    fun run() {
        do {
            inputBridgeLength()
            setNewBridge()
            game = BridgeGame(bridge)
            println(bridge.toString())
            playGame()
            inputGameAgain()
        } while (gameAgain)
    }

    private fun playGame() {
        while (!game.isDone) {
            val result = game.move(inputMoving(), currentTurn++)
            outputView.printMap(result)
        }
        game.retry()
    }

    private fun inputGameAgain() {
        var again = ""
        loopUntilValid {
            again = inputView.readGameCommand()
            InputValidator.validateCommand(again)
        }
        if (again == "R") {
            gameAgain = true
            return
        }
        gameAgain = false
    }

    private fun inputMoving(): String {
        var moving = ""
        loopUntilValid {
            moving = inputView.readMoving()
            InputValidator.validateMoving(moving)
        }
        return moving
    }

    private fun inputBridgeLength() {
        var rawLength = ""
        loopUntilValid {
            rawLength = inputView.readBridgeSize()
            InputValidator.validateBridgeLength(rawLength)
        }
        bridgeLength = rawLength.toInt()
    }

    private fun setNewBridge() {
        bridge = bridgeMaker.makeBridge(bridgeLength)
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