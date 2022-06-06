package ex_interface

interface Printable {
    fun print(): Unit
}

class AAA : Printable {
    override fun print() {
        println("Hello")
    }
}

fun print(anything: Printable) {
    anything.print()
}

fun main() {
    print(AAA())
}