package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이름은 5자 미만이여야한다`() {
        val testName = "test"
        assertThat(Car(name = testName).name)
            .isEqualTo(testName)
    }

    @Test
    fun `자동차 이름은 5자를 초과하는 경우 예외를 던진다`() {
        assertThatThrownBy { Car(name = "test12") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자가 4 이상이면 자동차가 한 칸 전진한다`() {
        assertThat(Car(distance = DEFAULT_DISTANCE).move(4).distance)
            .isEqualTo(DEFAULT_DISTANCE + 1)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않는다`() {
        assertThat(Car(distance = DEFAULT_DISTANCE).move(3).distance)
            .isEqualTo(DEFAULT_DISTANCE)
    }

    companion object {
        private const val DEFAULT_DISTANCE = 1
    }
}
