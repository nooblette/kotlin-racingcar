package racingcar.view

import racingcar.car.Cars

class ResultView {
    fun printResult(cars: Cars) {
        // 자동차들의 이동 거리 출력
        cars.list.forEach { car -> println(car.result) }
        println()
    }
}
