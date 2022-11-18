fun main(){
    val list = (0..10).map{
        (Math.random()*10000).toInt()   }.toMutableList()
    println("Original: $list")
    list.lexicographicalSort()
    println("Insertion sorted: $list")
}
