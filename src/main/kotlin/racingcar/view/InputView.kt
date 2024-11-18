package racingcar.view

object InputView {
    fun inputCarCount(): Int {
        // 자동차 대수 input 받기
        println("자동차 대수는 몇 대인가요?")
        return readlnOrNull()?.toInt() ?: 0
    }

    fun inputCarNames(): List<String> {
        // 자동차 대수 input 받기
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return (readlnOrNull() ?: "").split(",")
    }

    fun inputTryTime(): Int {
        // 시도 횟수 input 받기
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toInt() ?: 0
    }
}
