fun<T: Comparable<T>> MutableList<T>.partitionLomuto(low: Int, high: Int): Int{
    val pivot = this[high]
    var i = low
    for(j in low until high){
        if(this[j] <= pivot){
            this.swapAt(i, j)
            i += 1
        }
    }
    this.swapAt(i, high)
    return i
}

fun<T: Comparable<T>> MutableList<T>.quicksortLomuto(low: Int, high: Int){
    //새로운 list를 생성하는 것이 아닌 원본 List 상에서 작업이 이루어진다
    //=> Space Complexity 면에서 이점이 있다
    if(low<high){
        val pivot = this.partitionLomuto(low,high)
        this.quicksortLomuto(low, pivot-1)
        this.quicksortLomuto(pivot+1, high)
    }
}