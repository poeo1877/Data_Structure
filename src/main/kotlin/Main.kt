
fun main() {
    var list = LinkedList<Int>()
    list.push(value=10).push(value = 20).push(value=40).push(value=50).push(value=60).push(value=70)
    list.append(value = 6).append(value = 5).append(value = 4).append(value = 3).append(value = 2).append(value = 1)
    println("Before insertng: $list")

    var middleNode = list.nodeAt(5)!!
    for(i in 1..3){
        middleNode = list.insert((10-i), middleNode)
    }
    println("After insertng: $list")
}




