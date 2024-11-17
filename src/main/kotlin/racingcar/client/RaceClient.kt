package racingcar.client

import racingcar.car.Cars
import racingcar.race.Race
import racingcar.randomnumber.RandomNumbers
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
        var race = Race(cars = Cars(carCount))

        // 시도 횟수만큼 경주 반복
        resultView.printStart()
        for (i in 1..tryTime) {
            // 결과 출력
            resultView.printResult(race.cars)

            // 자동차 경주 시작
            val raceResult = race.run(RandomNumbers(carCount))

            // 결과 갱신
            race = Race(cars = raceResult)
        }

        // 갱신 후 마지막 경주 결과 출력
        resultView.printResult(race.cars)
    }
}
