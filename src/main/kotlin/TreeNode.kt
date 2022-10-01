class TreeNode<T>(val value:T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit  //지금 접근한 node가 뭔지 알려줌