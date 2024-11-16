package racingcar.randomnumber

import kotlin.random.Random

class RandomNumbers(
    val randomNumbers: List<Int>,
) {
    constructor(count: Int) : this(List(count) { Random.nextInt(0, 9) })
}
