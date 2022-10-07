import java.lang.Math.max
class BinaryNode<T>(val value:T) {
    var leftChild: BinaryNode<T>?=null
    var rightChild: BinaryNode<T>?= null

    private fun diagram(node: BinaryNode<T>?,
                        top: String = "",
                        root: String = "",
                        bottom: String = ""): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" +
                        diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }
    override fun toString() = diagram(this)

    fun traverseInOrder(visit: BinaryVisitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }
    fun traversePreOrder(visit: BinaryVisitor<T>){
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }
    fun traversePostOrder(visit: BinaryVisitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePreOrder(visit)
        visit(value)
    }
    fun hegith(node: BinaryNode<T>?=this):Int{
        return node?.let{
            1+max(hegith(node.leftChild), hegith(node.rightChild))   //현 Node 기준, 왼쪽 subtree의 height와 오른쪽 subtree의 height 중 더 큰 값을 더한다. {둘 다 원래 Node에 자식들이니 그 중 큰 값이 전체 계의 height이니까}
        }?: -1
    }
}

