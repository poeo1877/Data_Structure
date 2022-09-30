fun main() {
    val stack = Stack<Int>().apply {
        push(1)
        push(2)
        push(3)
        push(4)
    }
    print(stack)
    println(stack.peek())
    print(stack)
}

