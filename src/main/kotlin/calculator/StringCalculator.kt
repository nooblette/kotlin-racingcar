package calculator

import calculator.enum.Sign
import calculator.enum.Sign.ADD
import calculator.enum.Sign.DIVIDE
import calculator.enum.Sign.MULTIPLY
import calculator.enum.Sign.SUBTRACT

class StringCalculator : Calculator<String?> {
    override fun calculate(tokens: String?): Double {
        requireNotNull(tokens) { "입력값이 비어있습니다." }

        // 초기화
        val tokenList = tokens.split(" ")

        // 연산 결과 반환
        return compute(tokenList = tokenList)
    }

    private fun compute(tokenList: List<String>): Double {
        // 초기화
        var result = tokenList[0].toDouble()

        // 주어진 문자열을 순회하며 연산
        for (i in 1..<tokenList.size step 2) {
            val sign = Sign.getSignByString(tokenList[i])
            result = calculateByToken(result = result, sign = sign, number = tokenList[i + 1].toDouble())
        }
        return result
    }

    private fun calculateByToken(
        result: Double,
        sign: Sign,
        number: Double,
    ): Double {
        // 연산 기호별로 계산
        when (sign) {
            ADD -> return ADD.operation(result, number)
            SUBTRACT -> return SUBTRACT.operation(result, number)
            MULTIPLY -> return MULTIPLY.operation(result, number)
            DIVIDE -> {
                if (number == 0.0) {
                    throw IllegalArgumentException("0으로 나눌 수 없습니다.")
                }

                return DIVIDE.operation(result, number)
            }
        }
    }
}
