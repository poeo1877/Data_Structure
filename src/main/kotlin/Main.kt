
fun main() {
    val node1 = Node(value=1)
    val node2 = Node(value=2)
    val node3 = Node(value=3)
    val node4 = Node(value=4)
    val node5 = Node(value=5)
    val node6 = Node(value=6)


    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    println(node1)
}




