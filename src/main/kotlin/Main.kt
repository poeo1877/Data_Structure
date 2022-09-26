fun printNames(names: List<String>){
    for(name in names){
        println(name)
    }
}

fun main(){
    var names: List<String> = listOf("Kevin", "Mila", "Sally")
    printNames(names)
}