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

fun<T: Comparable<T>> MutableList<T>.partitionHoare(low: Int, high: Int):Int{
    val pivot = this[low]
    var i = low -1      //do-while에서 일단 1을 감소하기에 값을 조정...
    var j = high + 1
    while(true){
        do{
            j -= 1
        }while(this[j] > pivot)
        do{
            i += 1
        }while(this[i] < pivot)
        if(i<j){
            this.swapAt(i, j)
        } else{
            return j
        }
    }
}

fun<T: Comparable<T>> MutableList<T>.quicksortHoare(low: Int, high: Int){
    if(low < high) {
        val p = this.partitionHoare(low, high)
        this.quicksortHoare(low, p)
        this.quicksortHoare(p+1, high)
    }
}