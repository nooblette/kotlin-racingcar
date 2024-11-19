package racingcar.domain.service

import racingcar.domain.car.Cars
import racingcar.domain.race.Race
import racingcar.domain.randomnumber.RandomNumbers

class RaceService(
    val race: Race,
) {
    fun execute(
        tryTime: Int,
        onResult: (Cars) -> Unit,
        randomNumbers: List<RandomNumbers>,
    ): Race {
        var raceByStep = race
        for (i in 0..<tryTime) {
            // 자동차 경주 시작
            raceByStep = Race(raceByStep.run(randomNumbers[i]))

            // 결과 출력
            onResult(raceByStep.cars)
        }

        return raceByStep
    }
}
