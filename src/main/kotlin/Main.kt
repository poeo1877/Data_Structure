

fun main(){
    val array = arrayListOf(1,12,3,4,1,6,8,7)
    val h = MinHeap<Int>()
    h.heapify(array)
    while(!h.isEmpty){
        println(h.remove())
    }
}