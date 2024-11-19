package racingcar.race

import racingcar.car.Cars
import racingcar.randomnumber.RandomNumbers

class Race(
    val cars: Cars,
) {
    fun run(randomNumbers: RandomNumbers): Cars {
        // 자동차 경주
        return Cars(
            cars.list.mapIndexed
                { index, car -> car.move(randomNumbers.randomNumbers[index]) },
        )
    }
}
