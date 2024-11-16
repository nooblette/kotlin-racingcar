package racingcar.view

class InputView {
    fun inputCarCount(): Int {
        // 자동차 대수 input 받기
        println("자동차 대수는 몇 대인가요?")
        return readlnOrNull()?.toInt() ?: 0
    }

    fun inputTryTime(): Int {
        // 시도 횟수 input 받기
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toInt() ?: 0
    }
}
