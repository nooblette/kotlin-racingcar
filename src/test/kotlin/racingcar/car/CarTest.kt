package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `거리가 1 증가하는지 확인`() {
        val distance = 1

        assertThat(Car(distance).increment().distance)
            .isEqualTo(distance + 1)
    }
}
