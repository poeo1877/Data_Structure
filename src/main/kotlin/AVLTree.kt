import java.lang.Math.max

class AVLTree<T: Comparable<T>>{
    var root:AVLNode<T>?=null
    override fun toString()=root?.toString()?:"Empty Tree"

    //편향 이진 트리 꼴을 최대한 완전 이진 트리 형태로 만드는 것
    private fun leftRotate(node:AVLNode<T>):AVLNode<T>{
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        //height 값 조정
        node.height = max(node.leftHeight, node.rightHeight)+1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight)+1
        return pivot
    }
    private fun rightRotate(node:AVLNode<T>):AVLNode<T>{
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node

        //height 값 조정
        node.height = max(node.leftHeight, node.rightHeight)+1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight)+1
        return pivot
    }
    private fun rightLeftRotate(node: AVLNode<T>):AVLNode<T>{
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }
    private fun leftRightRotate(node: AVLNode<T>):AVLNode<T>{
        val leftChild = node.leftChild?:return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }
    private fun balanced(node:AVLNode<T>):AVLNode<T>{
        return when(node.balanceFactor){
            2->{
                if(node.leftChild?.balanceFactor == -1)
                    leftRightRotate(node)
                else
                    rightRotate(node)
            }
            -2 -> {
                if (node.rightChild?.balanceFactor==1)
                    rightLeftRotate(node)
                else
                    leftRotate(node)
            }
            else -> node
        }
    }
    private fun insert(node:AVLNode<T>?, value:T): AVLNode<T>?{
        node?:return AVLNode(value)
        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }else {
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode?.height = Math.max(balancedNode?.leftHeight?:0, balancedNode?.rightHeight?:0)+1
        return balancedNode
    }
    fun insert(value: T){
        root = insert(root, value)
    }

}