package racingcar.client

import racingcar.car.Cars
import racingcar.race.Race
import racingcar.randomnumber.RandomNumbers

class RaceClient(
    val carCount: Int,
    val tryTime: Int,
    val print: (Cars) -> Unit,
) {
    fun startRace() {
        // 입력받은 자동차 대수로 race 객체 생성
        var race = Race(cars = Cars(carCount))

        // 시도 횟수를 입력받아 경기 시작
        println("실행 결과")
        for (i in 1..tryTime) {
            // 결과 출력
            print(race.cars)

            // 경기 시작
            race = Race(cars = race.run(RandomNumbers(carCount)))
        }
    }
}
