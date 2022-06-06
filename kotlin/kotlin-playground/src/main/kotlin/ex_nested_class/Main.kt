package ex_nested_class

class Outer {
    private val property: Int = 16

    /*
    * 중첩 클래스는 실제로는 완전히 분리된 장소에
    * 존재하므로 어떠한 프로퍼티나 멤버변수에 접근할 수 없다
    */
    class Nested {
        private val property = 12
        fun hello() = println("중첩된 클래스")
        fun hello2() {
            return println(property)
        }
    }
}

fun main(args: Array<String>) {
    val instance: Outer.Nested = Outer.Nested()
    instance.hello()
    instance.hello2()
}

