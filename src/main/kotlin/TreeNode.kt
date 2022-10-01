class TreeNode<T>(val value:T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
    fun forEachLevelOrder(visit: Visitor<T>) { //LinkedListQueue부터 선행 必
        visit(this)
        val queue = LinkedListQueue<TreeNode<T>>()
        children.forEach{queue.enqueue(it)}
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach {queue.enqueue(it)}
            node = queue.dequeue()
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit  //지금 접근한 node가 뭔지 알려줌