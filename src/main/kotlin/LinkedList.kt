//import java.lang.IndexOutOfBoundsException
//
//class LinkedList<T>: Iterable<T>, Collection<T> {
//    private var head: Node<T>?=null
//    private var tail: Node<T>?=null
//    override var size = 0
//        private set
//
//    override fun iterator(): Iterator<T> {
//        return LinkedListIterator(this)
//    }
//
//    override fun isEmpty():Boolean{
//        return size == 0
//    }
//
//    override fun contains(element: T): Boolean {
//        for(item in this)
//            if (item == element)return true
//        return false
//    }
//
//    override fun containsAll(elements: Collection<T>): Boolean {
//        for(searched in elements)
//            if(!contains(searched))return false
//        return true
//    }
//
//
//    override fun toString(): String {
//        if(isEmpty()){
//            return "Empty list"
//        }
//        return head.toString()
//    }
//    fun push(value: T): LinkedList<T>{
//        head = Node(value = value, next =head)
//        if(tail == null){
//            tail = head
//        }
//        size++
//        return this
//    }
//    fun append(value:T):LinkedList<T>{
//        if(isEmpty()){
//            push(value)
//            return this
//        }
//        tail?.next=Node(value=value)
//        tail = tail?.next
//        size++
//        return this
//    }
//    fun nodeAt(index: Int): Node<T>?{
//        var currentNode = head
//        var currentIndex = 0
//        while (currentNode != null && currentIndex < index){
//            currentNode = currentNode.next
//            currentIndex++
//        }
//        return currentNode
//    }
//    fun insert(value: T, afterNode:Node<T>):Node<T> {
//        if (tail == afterNode) {
////            append(value)
//            return tail!!
//        }
//        val newNode = Node(value=value, next = afterNode.next)
//        afterNode.next = newNode
//        size++
//        return newNode
//    }
//
//    fun pop(): T? {
//        if(!isEmpty()) size--
//        val result = head?.value
//        head=head?.next
//        if (isEmpty()){
//            tail = null
//        }
//        return result
//    }
//
//    fun removeLast(): T? {
//        val head = head ?: return null
//        if(head.next==null)return pop()
//        size--
//        var prev = head
//        var current = head
//        var next=current.next
//        while(next != null){
//            prev = current
//            current = next
//            next = current.next
//        }
//        prev.next = null
//        tail = prev
//        return current.value
//    }
//
//    fun removeAfter(node: Node<T>):T?{
//        val result = node.next?.value
//        if (node.next == tail){
//            tail = node
//        }
//        if(node.next != null){
//            size--
//        }
//        node.next=node.next?.next
//        return result
//    }
//
//}
//
//class LinkedListIterator<K> (
//    private val list: LinkedList<K>
//) : Iterable<K> {
//    private var index = 0
//    private  var lastNode : Node<K>? = null
//
//    override fun next():K {
//        if(index >= list.size) throw IndexOutOfBoundsException()
//        lastNode = if (index==0){
//            list.nodeAt(0)
//        }else
//            lastNode?.next
//        index++
//        return lastNode!!.value
//    }
//
//    override fun hasNext(): Boolean {
//        return index < list.size
//    }
//}
