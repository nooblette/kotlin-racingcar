package racingcar.client

import racingcar.car.Cars
import racingcar.race.Race
import racingcar.randomnumber.RandomNumbers
import racingcar.service.RaceService
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceClient(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun startRace() {
        // 자동차 대수 입력 받기
        val carCount = inputView.inputCarCount()

        // 시도 횟수 입력 받기
        val tryTime = inputView.inputTryTime()

        // 입력받은 carCount만큼 자동차 목록을 갖는 race 객체 생성
        val race = Race(cars = Cars(carCount))
        val raceService = RaceService(race)

        // 경주 서비스 실행
        resultView.printStart()
        raceService.execute(
            tryTime = tryTime,
            onResult = resultView::printResult,
            randomNumbers = List(tryTime) { RandomNumbers(carCount) },
        )
    }
}
