package calculator

class StringCalculator : Calculator<String?> {
    override fun calculate(tokens: String?): Double {
        if (tokens?.isBlank() != false) {
            throw IllegalArgumentException("입력값이 비어있습니다.")
        }

        // 초기화
        val tokenList = tokens.split(" ")

        // 연산 결화 반환
        return compute(tokenList = tokenList)
    }

    private fun compute(tokenList: List<String>): Double {
        // 초기화
        var result = tokenList[0].toDouble()

        // 주어진 문자열을 순회하며 연산
        for (i in 1..<tokenList.size step 2) {
            val sign = tokenList[i]
            val number = tokenList[i + 1].toDouble()

            result = calculateByToken(result = result, sign = sign, number = number)
        }
        return result
    }

    private fun calculateByToken(
        result: Double,
        sign: String,
        number: Double,
    ): Double {
        // 연산 기호별로 계산
        if (sign == "+") {
            return result + number
        }

        if (sign == "-") {
            return result - number
        }

        if (sign == "*") {
            return result * number
        }

        if (sign == "/") {
            if (number == 0.0) {
                throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            }

            return result / number
        }

        throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
    }
}
