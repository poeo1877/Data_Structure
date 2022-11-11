fun main(){
    val list = arrayListOf(9, 4, 10, 3, 12,2,1, 1, 410, 88, 1772)
    println("Original: $list")
    list.radixSort()
    println("Insertion sorted: $list")
}
