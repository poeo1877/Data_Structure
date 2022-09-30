fun String.checkParenntheses():Boolean {
    val stack=Stack<Char>()
    for(character in this){
        when (character){
            '('->stack.push(character)
            ')'->if(stack.isEmpty){
                return false
            }else{
                stack.pop()
            }
        }
    }

    return stack.isEmpty
}


fun main() {
    var s ="h((e))llo(world)()"
    println(s.checkParenntheses())
    println("(hello world".checkParenntheses())
}

