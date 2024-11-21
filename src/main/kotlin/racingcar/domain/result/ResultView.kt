package racingcar.domain.result

import racingcar.domain.car.Cars

object ResultView {
    private const val PRINT_EXPRESSION = "-"

    fun printStart() {
        println("실행 결과")
    }

    fun printResult(cars: Cars) {
        // 자동차들의 이동 거리 출력
        cars.list.forEach { car -> println("${car.name} : ${PRINT_EXPRESSION.repeat(car.distance)}") }
        println()
    }

    fun printWinner(winner: String) {
        println("${winner}가 최종 우승했습니다.")
    }
}
