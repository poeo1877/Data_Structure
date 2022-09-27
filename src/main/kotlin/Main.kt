
fun main() {
    var list = LinkedList<Int>()
    var poppedValue = list.pop()
    println(poppedValue)

    list.push(value=10).push(value = 20).push(value=40).push(value=50).push(value=60).push(value=70)

    println("Before popping list: $list")
    poppedValue=list.pop()
    println("After popping list: $list")
    println("Popped Value: $poppedValue")

}




