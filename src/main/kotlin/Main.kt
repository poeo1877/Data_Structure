fun main() {
    val queue = ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
    }
    println(queue)
    println(queue.dequeue())
    println(queue)
    println("Next up: ${queue.peek()}")
}
