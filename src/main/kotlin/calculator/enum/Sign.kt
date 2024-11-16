package calculator.enum

enum class Sign(
    private val sign: String,
    val operation: (Double, Double) -> Double,
) {
    ADD("+", { x, y -> x + y }),
    SUBTRACT("-", { x, y -> x - y }),
    MULTIPLY("*", { x, y -> x * y }),
    DIVIDE("/", { x, y -> x / y }),
    ;

    companion object {
        fun getSignByString(sign: String): Sign? =
            entries
                .filter { it.sign == sign }
                .getOrNull(0)
    }
}
