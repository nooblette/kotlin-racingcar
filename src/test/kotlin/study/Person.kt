package study

class Person(
    // 프로퍼티(property) : field + getter + setter
    val name: String,
    val age: Int,
    // nullable, nickname을 생성자에서 전달받지 않았으면 기본 값으로 name을 따르도록 하자
    var nickname: String? = name,
)
