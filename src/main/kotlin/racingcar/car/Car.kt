package racingcar.car

class Car(
    val distance: Int = 1,
) {
    // 이동 거리를 1 증가한다.
    fun increment(): Car = Car(distance + 1)
}
