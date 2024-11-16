package racingcar.car

class Cars(
    private val carCount: Int,
    val list: List<Car> = List(carCount) { Car() },
) {
    // 추가 생성자 구현
    constructor(list: List<Car>) : this(carCount = list.size, list = list)
}
