fun checkFirst(name: List<String>){
    if(name.firstOrNull()!=null){
        println(name.first())
    }else{
        println("no names")
    }
}

fun main(){
    var names: List<String> = listOf("Kevin", "Mila", "Sally")
    checkFirst(names)
}