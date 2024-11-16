package calculator

interface Calculator<T> {
    fun calculate(tokens: T): Double
}
