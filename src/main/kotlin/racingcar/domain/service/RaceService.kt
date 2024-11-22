package racingcar.domain.service

import racingcar.domain.car.Cars
import racingcar.domain.race.Race
import racingcar.domain.randomnumber.RandomNumbers
import racingcar.domain.result.ResultView

class RaceService(
    val race: Race,
) {
    fun execute(
        tryTime: Int,
        randomNumbers: List<RandomNumbers>,
    ): Race {
        val raceResultByStep = mutableListOf<Cars>()

        var raceByStep = race
        for (i in 0..<tryTime) {
            // 자동차 경주 시작
            raceByStep = Race(raceByStep.run(randomNumbers[i]))

            // 결과 추가
            raceResultByStep.add(raceByStep.cars)
        }

        // 자동차 결과 출력
        raceResultByStep.forEach { result -> ResultView.printResult(result) }

        return raceByStep
    }
}
