package calculator.enum

enum class Sign(
    private val sign: String,
    val operation: (Double, Double) -> Double,
) {
    ADD("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y ->
        if (y == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        x / y
    }),
    ;

    companion object {
        fun getSignByString(sign: String): Sign =
            entries.find { it.sign == sign }
                ?: throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
    }
}
