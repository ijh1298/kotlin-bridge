package bridge.validator

import bridge.utils.Error

object InputValidator {
    fun validateBridgeLength(rawLength: String) {
        require(Regex("^\\d+$").matches(rawLength)) { Error.INVALID_BRIDGE_LENGTH }
        require(rawLength.toInt() in 3..20) { Error.INVALID_BRIDGE_LENGTH }
    }

    fun validateMoving(rawMoving: String) {
        require(rawMoving == "U" || rawMoving == "D") { Error.INVALID_INPUT }
    }

    fun validateCommand(rawCommand: String) {
        require(rawCommand == "R" || rawCommand == "Q") { Error.INVALID_INPUT }
    }
}