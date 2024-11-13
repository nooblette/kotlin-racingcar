package calculator.enum

enum class Sign(
    val sign: String,
) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun getSignByString(sign: String): Sign? =
            entries
                .filter { it.sign == sign }
                .getOrNull(0)
    }
}
