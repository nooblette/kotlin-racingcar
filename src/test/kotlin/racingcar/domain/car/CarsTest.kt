package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `우승자 조회 로직을 테스트한다`() {
        // 이름이 a인 자동차가 최종 우승을 한 Race 객체 생성
        val cars = Cars(List(carCount) { Car(distance = defaultDistance) } + getTestWinner())

        // 우승자가 a 자동차가 맞는지 검증
        assertThat(cars.getWinners())
            .isEqualTo(Cars(list = getTestWinner()))
    }

    companion object {
        private var defaultDistance = 2
        private var carCount = 3

        private fun getTestWinner(): List<Car> = listOf(Car(name = "a", distance = defaultDistance + 2))
    }
}
