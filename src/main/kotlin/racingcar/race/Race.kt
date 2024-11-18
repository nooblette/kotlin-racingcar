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

    // 우승자 조회
    fun getWinners(): Cars {
        // 최장 이동 거리를 찾는다.
        val maxDistance = cars.list.maxBy { it.distance }.distance

        // 최장 이동거리에 해당하는 Car 목록을 반환한다.
        val winners = cars.list.filter { it.distance == maxDistance }
        return Cars(winners)
    }
}
