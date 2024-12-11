package bridge

class BridgeGame(
    private val bridge: List<String>
) {
    var isDone = false
    private val upBridge = mutableListOf<String>()
    private val bottomBridge = mutableListOf<String>()

    fun move(command: String, index: Int): Pair<List<String>, List<String>> {
        val isCorrect = command == bridge[index]
        updateUpBridge(command, isCorrect)
        updateBottomBridge(command, isCorrect)

        if (!isCorrect || index == bridge.size - 1)
            isDone = true

        return upBridge to bottomBridge
    }

    fun retry() {}

    private fun updateUpBridge(command: String, isCorrect: Boolean) {
        if (command == "U" && isCorrect) {
            upBridge += "O"
            return
        }
        if (isCorrect) {
            upBridge += ""
            return
        }
        upBridge += "X"
    }

    private fun updateBottomBridge(command: String, isCorrect: Boolean) {
        if (command == "D" && isCorrect) {
            bottomBridge += "O"
            return
        }
        if (isCorrect) {
            bottomBridge += ""
            return
        }
        bottomBridge += "X"
    }
}
