import kotlin.Comparator

private fun leftChildIndex(index: Int) = (2 * index) + 1
private fun rightChildIndex(index: Int) = (2 * index) + 2

fun <T> Array<T>.siftDown(
    index: Int,
    upTo: Int,
    comparator: Comparator<T>
){
    var parent = index
    while(true){
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate = parent
        if(left < upTo && comparator.compare(this[left], this[candidate]) > 0 ) {
            candidate = left
        }
        if(right < upTo && comparator.compare(this[right], this[candidate]) > 0){
            candidate = right
        }
        if(candidate == parent){        //더 이상 swap 할 것이 없으면,
            return
        }
        this.swapAt(parent, candidate)
        parent = candidate
    }
1}

fun <T> Array<T>.heapify(comparator: Comparator<T>){
    if (this.isNotEmpty()){
        (this.size/2 downTo 0).forEach {
            this.siftDown(it, this.size, comparator)
        }
    }
}

fun <T> Array<T>.heapSort(comparator: Comparator<T>){
    this.heapify(comparator)        //정렬할 구간을 heapify한다.
    for(index in this.indices.reversed()){      //가장 뒤의 index부터 하나씩... 0으로
        this.swapAt(0, index)                   //MaxHeap || MinHeap item과 맨 뒤를 swap
        siftDown(0, index, comparator)
    }
}