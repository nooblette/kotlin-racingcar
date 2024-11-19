package racingcar.client

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.race.Race
import racingcar.domain.randomnumber.RandomNumbers
import racingcar.domain.service.RaceService
import racingcar.view.InputView
import racingcar.view.ResultView

class RaceClient {
    fun startRace() {
        // 자동차 이름 입력받아 Cars 객체 생성
        val inputCars = getInputCars()

        // 입력받은 이름으로 생성된 자동차 목록으로 Race 객체 생성
        val race = Race(cars = inputCars)
        val raceService = RaceService(race)

        // 시도 횟수 입력 받기
        val tryTime = InputView.inputTryTime()

        // 경주 서비스 실행
        val raceResult = executeRace(tryTime, race.cars.list.size, raceService::execute)

        // 경주 결과 중 우승자를 찾는다.
        ResultView.printWinner(
            raceResult.cars
                .getWinners()
                .list
                .joinToString { it.name },
        )
    }

    private fun getInputCars(): Cars {
        // 자동차 이름 입력 받기
        val carNames = InputView.inputCarNames()

        // 입력받은 자동차 이름들로 Cars 객체 생성
        return Cars(list = carNames.map { carName -> Car(name = carName) })
    }

    // 자동차 경주 실행
    private fun executeRace(
        tryTime: Int,
        carCount: Int,
        execute: (Int, (Cars) -> Unit, List<RandomNumbers>) -> Race,
    ): Race {
        ResultView.printStart()
        return execute(tryTime, ResultView::printResult, List(tryTime) { RandomNumbers(carCount) })
    }
}
