package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `입력값이 비어있는 경우 예외를 던진다`() {
        assertThatThrownBy { StringCalculator().calculate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력값이 null인 경우 예외를 던진다`() {
        assertThatThrownBy { StringCalculator().calculate(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
