package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `숫자가 4 이상이면 자동차가 한 칸 전진한다`() {
        assertThat(Car(DEFAULT_DISTANCE).move(4).distance)
            .isEqualTo(DEFAULT_DISTANCE + 1)
    }

    @Test
    fun `숫자가 4 미만이면 전진하지 않는다`() {
        assertThat(Car(DEFAULT_DISTANCE).move(3).distance)
            .isEqualTo(DEFAULT_DISTANCE)
    }

    companion object {
        private const val DEFAULT_DISTANCE = 1
    }
}
