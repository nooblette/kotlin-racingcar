package calculator

import calculator.enum.Sign
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

    @Test
    fun `덧셈 연산 성공 테스트`() {
        assertThat(Sign.ADD.operation(3.0, 2.0))
            .isEqualTo(5.0)
    }

    @Test
    fun `뺄셈 연산 성공 테스트`() {
        assertThat(Sign.SUBTRACT.operation(3.0, 2.0))
            .isEqualTo(1.0)
    }

    @Test
    fun `곱셈 연산 성공 테스트`() {
        assertThat(Sign.MULTIPLY.operation(3.0, 2.0))
            .isEqualTo(6.0)
    }

    @Test
    fun `나눗셈 연산 성공 테스트`() {
        assertThat(Sign.DIVIDE.operation(3.0, 2.0))
            .isEqualTo(1.5)
    }
}
