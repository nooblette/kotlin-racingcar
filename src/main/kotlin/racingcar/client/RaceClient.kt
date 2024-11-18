package racingcar.client

import racingcar.car.Cars
import racingcar.race.Race
import racingcar.randomnumber.RandomNumbers
import racingcar.service.RaceService
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceClient {
    fun startRace() {
        // 자동차 이름 입력 받기
        val carNames = InputView.inputCarNames()
        val carCount = carNames.size

        // 시도 횟수 입력 받기
        val tryTime = InputView.inputTryTime()

        // 입력받은 carCount만큼 자동차 목록을 갖는 race 객체 생성
        val race = Race(cars = Cars(carCount))
        val raceService = RaceService(race)

        // 경주 서비스 실행
        ResultView.printStart()
        raceService.execute(
            tryTime = tryTime,
            onResult = ResultView::printResult,
            randomNumbers = List(tryTime) { RandomNumbers(carCount) },
        )
    }
}
