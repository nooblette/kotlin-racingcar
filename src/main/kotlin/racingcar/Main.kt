package racingcar

import racingcar.client.RaceClient
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.inputCarCount()
    val tryTime = inputView.inputTryTime()

    val raceClient =
        RaceClient(
            carCount = carCount,
            tryTime = tryTime,
            print = ResultView()::printResult,
        )

    // 경기 시작 호출
    raceClient.startRace()
}
