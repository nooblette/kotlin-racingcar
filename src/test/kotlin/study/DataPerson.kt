package study

// data : 생성자에 선언된 프로퍼티를 기반으로 toString, isEqualTo, hashCode 등을 자동으로 컴파일시점에 오버라이딩한다.
data class DataPerson(
    // 프로퍼티(property) : field + getter + setter
    val name: String,
    val age: Int,
    // nullable, nickname을 생성자에서 전달받지 않았으면 기본 값으로 name을 따르도록 하자
    var nickname: String? = name,
) {
    // 생성자에 없는 프로퍼티는 toString, isEqualTo, hashCode에 오버라이딩되지 않는다.
    val a: String = ""
}
