

fun main(){
  val stringLengthComparator = object : Comparator<String> {
      override fun compare(o1: String?, o2: String?): Int {
          val length1 = o1?.length ?: -1
          val length2 = o2?.length ?: -1
          return length1 - length2
      }
  }
    val priorityQueue = PriorityQueue<String>(stringLengthComparator)
    arrayListOf("one", "two", "three", "forty", "five", "six", "seven", "eight", "nine").forEach{
        priorityQueue.enqueue(it)
    }
    while(!priorityQueue.isEmpty){
        println(priorityQueue.dequeue())
    }
}