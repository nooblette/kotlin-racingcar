package racingcar.domain.car

data class Cars(
    private val carCount: Int,
    val list: List<Car> = List(carCount) { Car() },
) {
    // 추가 생성자 구현
    constructor(list: List<Car>) : this(carCount = list.size, list = list)

    // 우승자 조회
    fun getWinners(): Cars {
        // 최장 이동 거리를 찾는다.
        val maxDistance = list.maxBy { it.distance }.distance

        // 최장 이동거리에 해당하는 Car 목록을 반환한다.
        val winners = list.filter { it.distance == maxDistance }
        return Cars(winners)
    }
}
