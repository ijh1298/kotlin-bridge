package bridge.utils

enum class Error(val msg: String) {
    INVALID_BRIDGE_LENGTH("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 한다."),
    INVALID_INPUT("[ERROR] 올바른 입력이 아닙니다.")
}