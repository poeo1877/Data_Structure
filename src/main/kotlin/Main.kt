fun main(){
    val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
    array.heapSort(Comparator{o1: Int, o2:Int -> o2 - o1})  //내림차순으로 정렬...
    print(array.joinToString())
}
