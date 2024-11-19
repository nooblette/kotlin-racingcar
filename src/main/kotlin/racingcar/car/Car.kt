package racingcar.car

data class Car(
    val name: String = "",
    val distance: Int = 0,
) {
    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    // 값이 4 이상인 경우 자동차가 한 칸 전진한다.
    fun move(value: Int): Car =
        if (value >= 4) {
            Car(name = name, distance = distance + 1)
        } else {
            Car(name = name, distance = distance)
        }
}
