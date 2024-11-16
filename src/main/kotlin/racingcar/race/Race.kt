package racingcar.race

import racingcar.car.Car
import racingcar.car.Cars
import racingcar.randomnumber.RandomNumbers

class Race(
    val cars: Cars,
) {
    fun run(randomNumbers: RandomNumbers): Cars {
        // 인덱스별 이동 여부 확인
        val moveConditions = randomNumbers.randomNumbers.map { number -> number >= 4 }

        // 자동차 경주
        return Cars(cars.list.mapIndexed { index, car -> move(moveConditions[index], car) })
    }

    private fun move(
        isMove: Boolean,
        car: Car,
    ): Car =
        if (isMove) {
            car.increment()
        } else {
            car
        }
}
