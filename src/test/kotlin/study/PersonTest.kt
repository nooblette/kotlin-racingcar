package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름_붙인_인자`() {
        // 아래 코드만으론 어떤 매개변수가 name 필드이고 어떤 매개변수가 nickname 필드인지 알 수 없다.
        val person = Person("오민혁", 28, "nooblette")

        // 코틀린의 named parameter를 활용하면 어떤 매개변수가 어떤 필드에 추가되는지 지정할 수 있다.
        val personWithNameParameter = Person(name = "오민혁", age = 28, nickname = "nooblette")

        // 파라미터 전달 순서도 메서드 시그니처에 구애받지 않는다.
        val personWithRandomParameterOrder = Person(age = 28, name = "오민혁", nickname = "nooblette")
        assertThat(personWithRandomParameterOrder.name).isEqualTo("오민혁")
        assertThat(personWithRandomParameterOrder.age).isEqualTo(28)
        assertThat(personWithRandomParameterOrder.nickname).isEqualTo("nooblette")
    }

    @Test
    fun `널 타입`() {
        // non-null type 필드에 null을 할당할 수 없다.
        // Person(name = null, age = 28, nickname = "nooblette")

        // nullable 필드에는 null을 할당할 수 있다.
        val person = Person(name = "오민혁", age = 28, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        // nickname 필드를 생성자에서 전달받지 않았으면 기본 값으로 name을 따르도록 하자
        val person = Person(name = "오민혁", age = 28)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "오민혁", age = 28)
        val person2 = Person(name = "오민혁", age = 28)
        assertThat(person1).isNotEqualTo(person2)

        val dataPerson1 = DataPerson(name = "오민혁", age = 28)
        val dataPerson2 = DataPerson(name = "오민혁", age = 28)
        assertThat(dataPerson1).isEqualTo(dataPerson2)
    }
}
