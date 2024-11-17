package racingcar

import racingcar.client.RaceClient
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val raceClient = RaceClient(InputView(), ResultView())

    // 자동차 경주 시작
    raceClient.startRace()
}
