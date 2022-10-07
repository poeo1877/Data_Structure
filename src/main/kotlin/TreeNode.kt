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
    fun search(value: T):TreeNode<T>?{
        var result: TreeNode<T>?= null
        forEachLevelOrder {
            if(it.value==value){
                result = it
            }
        }
        return result
    }

    override fun toString(): String {
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesleftInCurrentLevel = 0
        var ret = ""
        queue.enqueue(this)
        while (queue.isEmpty.not()){
            nodesleftInCurrentLevel = queue.count
            while(nodesleftInCurrentLevel > 0){
                val node = queue.dequeue()
                node?.let {
                    ret += "${node.value} "
                    node.children.forEach{ queue.enqueue(it) }
                    nodesleftInCurrentLevel--
                } ?: break
            }
            ret += "\n"
        }
        return ret
    }
}

typealias Visitor<T> = (TreeNode<T>) -> Unit  //지금 접근한 node가 뭔지 알려줌

typealias  BinaryVisitor<T> = (T) -> Unit