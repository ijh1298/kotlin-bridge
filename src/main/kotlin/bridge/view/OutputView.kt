package bridge.view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    fun printStartMessage() {
        println("다리 건너기 게임을 시작합니다.")
    }

    fun printMap(bridges: Pair<List<String>, List<String>>) {
        val upBridge = bridges.first.joinToString(" | ")
        val downBridge = bridges.second.joinToString(" | ")
        println("[ $upBridge ]\n[ $downBridge ]")
    }

    fun printResult() {}
}
