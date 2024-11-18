package racingcar.car

data class Car(
    val distance: Int = 0,
) {
    // 값이 4 이상인 경우 자동차가 한 칸 전진한다.
    fun move(value: Int): Car =
        if (value >= 4) {
            Car(distance + 1)
        } else {
            Car(distance)
        }
}
