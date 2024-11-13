package calculator

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `사칙연산 기호가 아닌 문자가 포함되는 경우 예외를 던진다`() {
        assertThatThrownBy { StringCalculator().calculate("2 ( 3 * 4 / 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `0으로 나누는 경우 예외를 던진다`() {
        assertThatThrownBy { StringCalculator().calculate("2 + 3 / 0 - 0") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `계산 성공`() {
        assertThat(StringCalculator().calculate("2 + 3 * 4 / 2"))
            .isEqualTo(10.0)
    }
}
