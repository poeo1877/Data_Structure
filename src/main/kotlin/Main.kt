fun linearContains(value: Int, numbers: List<Int>): Boolean {
    for(element in numbers){
        if(element == value){
            return true
        }
    }
    return false
}

fun main(){
    val numbers = listOf(1, 3, 56, 66, 68, 80, 99, 105, 450)
    println(linearContains(99, numbers))
}