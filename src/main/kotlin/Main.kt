
fun main() {
    var list = LinkedList<Int>()
    list.push(value=10).push(value = 20).push(value=40).push(value=50).push(value=60).push(value=70)

    println("Before removing last node: $list")
    val removedValue = list.removeLast()

    println("After removing last node: $list")
    println("Removed Value: $removedValue")

}




