package racingcar.domain.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.race.Race
import racingcar.domain.randomnumber.RandomNumbers

class RaceServiceTest {
    @Test
    fun `시도 횟수만큼 자동차 경주를 반복하고 결과를 확인한다`() {
        val carCount = 3
        val tryTime = 5
        val raceService = RaceService(Race(Cars(carCount = carCount)))

        val randomNumbers =
            List(tryTime) {
                RandomNumbers(
                    listOf(
                        // 1번 자동차만 한칸씩 이동한다.
                        MOVE_CONDITION,
                        MOVE_CONDITION - 1,
                        MOVE_CONDITION - 1,
                    ),
                )
            }

        val raceResult = raceService.execute(tryTime = tryTime, onResult = { }, randomNumbers = randomNumbers)

        // 경기 결과 검증
        assertThat(raceResult.cars.list)
            .containsExactly(Car(distance = tryTime), Car(), Car())
    }

    companion object {
        private const val MOVE_CONDITION = 4
    }
}
