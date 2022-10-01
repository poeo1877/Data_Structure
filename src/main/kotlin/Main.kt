fun main() {
    val queue =  ArrayListQueue<String>().apply {
        enqueue("Ray")
        enqueue("Brian")
        enqueue("Eric")
        enqueue("Jack")
        enqueue("Hoodie")
    }
    println("before: $queue")
    queue.reverse()
    println("after: $queue")
}
