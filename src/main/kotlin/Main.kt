import kotlin.collections.ArrayDeque

fun main() {
    val arDeque = ArrayDeque<Int>()
    arDeque.add(1)
    arDeque.add(2)
    arDeque.add(5)
    arDeque.add(10)
    arDeque.addLast(8)
    arDeque.addFirst(23)

    println(arDeque)

    arDeque.removeLast()
    println(arDeque)
}
