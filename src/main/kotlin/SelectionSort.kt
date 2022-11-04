fun <T: Comparable<T>> ArrayList<T>.selectionSort(showPass: Boolean = false) {
    if(this.size < 2) return
    for (current in 0 until (this.size -1)){
        var lowest = current
        for (other in (current + 1) until this.size){
            if(this[lowest] > this[other]) {
                lowest = other
            }
        }
        if(lowest != current) {
            this.swapAt(lowest, current)
        }
        if(showPass) println(this)
    }
}