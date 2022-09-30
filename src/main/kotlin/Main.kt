fun main() {
    val queue = LinkedListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
        enqueue("Jack")
        enqueue("Hoodie")

    }
    println(queue)
    println(queue.dequeue())
    println(queue)
    println("Next up: ${queue.peek()}")
}
