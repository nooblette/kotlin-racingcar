package calculator

class StringCalculator : Calculator<String?> {
    override fun calculate(tokens: String?): Double {
        if (tokens?.isBlank() != false) {
            throw IllegalArgumentException("입력값이 비어있습니다.")
        }

        // 초기화
        val tokenList = tokens.split(" ")
        var result = tokenList[0].toDouble()

        // 주어진 문자열을 순회하며 연산
        for (i in 1..<tokenList.size step 2) {
            if (tokenList[i] == "+") {
                result += tokenList[i + 1].toDouble()
            } else if (tokenList[i] == "-") {
                result -= tokenList[i + 1].toDouble()
            } else if (tokenList[i] == "*") {
                result *= tokenList[i + 1].toDouble()
            } else if (tokenList[i] == "/") {
                if (tokenList[i + 1].toDouble() == 0.0) {
                    throw IllegalArgumentException("0으로 나눌 수 없습니다.")
                }

                result /= tokenList[i + 1].toDouble()
            } else {
                throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
            }
        }

        return result
    }
}
