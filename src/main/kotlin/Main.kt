

fun main(){
    val p1 = Person("Josh", 21, true)
    val p2 = Person("Jake", 22, true)
    val p3 = Person("Clay", 28, false)
    val p4 = Person("Cindy", 28, false)
    val p5 = Person("Sabrina", 30, false)
    val priorityQueue = PriorityQueue(MilitaryPersonComparator)
    arrayListOf(p1,p2,p3,p4,p5).forEach{
        priorityQueue.enqueue(it)
    }
    while(!priorityQueue.isEmpty){
        println(priorityQueue.dequeue())
    }

}