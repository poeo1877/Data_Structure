

fun main(){
    val priorityQueue = MaxPriorityQueue<String>()

    arrayListOf("one", "two", "three", "forty", "five", "six", "seven", "eight", "nine").forEach{
        priorityQueue.enqueue(it)
    }
    while (!priorityQueue.isEmpty){
        println(priorityQueue.dequeue())
    }
}