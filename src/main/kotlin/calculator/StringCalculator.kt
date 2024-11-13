package calculator

class StringCalculator : Calculator<String?> {
    override fun calculate(tokens: String?): Double {
        if (tokens?.isBlank() != false) {
            throw IllegalArgumentException("입력값이 비어있습니다.")
        }

        return 0.0
    }
}
