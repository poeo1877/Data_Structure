
fun main() {
    var list = LinkedList<Int>()
    list.push(value=10).push(value = 20).push(value = 30).push(value=40).push(value=50).push(value=60).push(value=70)

    println("Before removing at particular node: $list")
    var index = 3
    val node = list.nodeAt(index -1)!!
    val removedValue = list.removeAfter(node)
    println("After removing at index $index: $list")
    println("Removed Value: $removedValue")

}




