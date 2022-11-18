fun main(){
    val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
    println("Original: $list")
    list.quicksortHoare(0, list.size-1)
    println("Sorted: $list")

}
