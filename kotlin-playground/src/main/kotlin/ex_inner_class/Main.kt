package ex_inner_class

class Outer(private val value: Int) {
    fun print() {
        println(this.value)
    }

    /*내부 클래스의 인스턴스는 자신이 속해있는
    바깥클래스의 인스턴스를 가리키는 참조변수를 내부적으로 갖고있음*/
    inner class Inner(private val innerValue: Int) {
        fun print() {
            this@Outer.print()
            println(this.innerValue + this@Outer.value)
        }
    }
}


fun main(args: Array<String>) {
    val instance: Outer = Outer(610)
    val innerInstance: Outer.Inner = instance.Inner(40)
    innerInstance.print()
}