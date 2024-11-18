package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.car.Cars
import racingcar.race.Race
import racingcar.randomnumber.RandomNumbers

class RaceTest {
    private var defaultDistance = 2
    private var carCount = 3

    private val race = Race(Cars(List(carCount) { Car(distance = defaultDistance) }))

    @Test
    fun `모두 이동하는 경우`() {
        assertThat(race.run(RandomNumbers(List(carCount) { 4 })).list)
            .allMatch { it.distance == defaultDistance + 1 }
    }

    @Test
    fun `모두 이동하지 않는 경우`() {
        assertThat(race.run(RandomNumbers(List(carCount) { 3 })).list)
            .allMatch { it.distance == defaultDistance }
    }

    @Test
    fun `일부만 이동하는 경우`() {
        // 이동하지 않을 인덱스
        val notMoveIndex = 1
        val numberList = MutableList(carCount) { 4 }
        numberList[notMoveIndex] = 3

        val result = race.run(RandomNumbers(numberList))

        // 겁증
        for (i in 0..carCount - 1) {
            val expectedDistance = if (i == notMoveIndex) defaultDistance else defaultDistance + 1
            assertThat(result.list[i].distance).isEqualTo(expectedDistance)
        }
    }

    @Test
    fun `우승자 조회 로직을 테스트한다`() {
        // 이름이 a인 자동차가 최종 우승을 한 Race 객체 생성
        val race = Race(Cars(List(carCount) { Car(distance = defaultDistance) } + getTestWinner()))

        // 우승자가 a 자동차가 맞는지 검증
        assertThat(race.getWinners())
            .isEqualTo(Cars(list = getTestWinner()))
    }

    private fun getTestWinner(): List<Car> = listOf(Car(name = "a", distance = defaultDistance + 2))
}
