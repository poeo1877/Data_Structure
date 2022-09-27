import kotlin.reflect.typeOf

fun main() {
    var list = LinkedList<Int>()
    list.push(value=10).push(value = 20).push(value = 30).push(value=40).push(value=50).push(value=60).push(value=70)

    var list2 = LinkedList<Int>()
    list2.append(10)
    println(list.containsAll(list2))
    list2.append(-1)
    println(list.containsAll(list2))
}




