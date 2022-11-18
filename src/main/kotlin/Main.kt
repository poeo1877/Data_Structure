fun main(){
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    array.heapSort(Comparator{o1: Int, o2:Int -> o1 - o2})
    print(array.joinToString())
}
