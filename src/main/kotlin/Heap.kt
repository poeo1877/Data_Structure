import java.util.Collections

interface MyCollection<Element> {
    val count: Int
        get
    val isEmpty: Boolean
        get() = count == 0
    fun insert(element: Element)
    fun remove(): Element?
    fun remove(index: Int): Element?
}

interface HeapInterface<Element> : MyCollection<Element> {
    fun peek(): Element?    //node의 값을 볼 수 있게 하는 함수
}

abstract class AbstractHeap<Element>(): HeapInterface<Element>{
    //max or min Heap 무관하게 공통인 것 정의...
    var elements: ArrayList<Element> = ArrayList<Element>()
    override val count: Int
        get() = elements.size //elements의 item 개수를 가져옴 즉, tree에 있는 모든 노드 개수

    override fun peek():Element? = elements.first()  //root node의 값을 보게 override
    private fun leftChildIndex(index: Int) = (2*index)+1
    private fun rightChildIndex(index: Int) = (2*index)+2
    private fun parentIndex(index: Int)= (index-1)/2

    abstract fun compare(a: Element, b: Element) : Int //이 함수를 어떻게 구현하는지에 따라 Maxheap or Minheap으로 갈린다

    private fun siftUp(index: Int){
        var child = index
        var parent = parentIndex(child)
        while (child > 0 && compare(elements[child], elements[parent])>0){
            Collections.swap(elements, child,parent) //import java.util.Collections가 추가돼 사용 가능한 코드
            child = parent
            parent = parentIndex(child)
        }
    }

    override fun insert(element: Element){
        elements.add(element)
        siftUp(count-1)
    }

    private fun siftDown(index:Int){
        var parent = index
        while(true){
            val left = leftChildIndex(parent)
            val right = rightChildIndex(parent)
            var candidate = parent
            if (left < count &&
                compare(elements[left], elements[candidate]) > 0) {
                candidate = left
            }
            if (right < count &&
                compare(elements[right], elements[candidate]) > 0) {
                candidate = right
            }
            if(candidate == parent)
                return
            Collections.swap(elements, parent, candidate)
            parent = candidate
        }
    }
    override fun remove():Element? {
        if(isEmpty) return null
        Collections.swap(elements, 0, count - 1)
        val item = elements.removeAt(count - 1)
        siftDown(0)
        return item
    }
    override fun remove(index : Int): Element? {
        if (index >= count) return null
        //조건에 따라 return 대상(각 code block에서 가장 마지막 줄)이 달라진다...
        return if (index == count - 1) {
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, 0, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item //heap에서 root node 값을 반환해주는 것
        }
    }

    private fun index(element: Element, i: Int): Int?{
        /// i는 재귀호출을 위한 값
        if(i>= count)
            return null
        if(compare(element, elements[i])>0)
            return null
        if(element == elements[i])
            return i

        var leftChildIndex = index(element, leftChildIndex(i))
        if(leftChildIndex != null) return leftChildIndex
        val rightChildIndex = index(element, rightChildIndex(i))
        if(rightChildIndex != null)return rightChildIndex
        return null
    }

    //임의의 배열을 heap으로 만드는 것
    fun heapify(values: ArrayList<Element>){
        elements = values
        if(!elements.isEmpty()){
            (count/2 downTo 0).forEach{
                siftDown(it)
            }
        }
    }
    fun getNthSmallestElement(n: Element): Element? {
        var current = 1
        while(!isEmpty){
            val element = remove()
            if(current == n){
                return element
            }
            current += 1
        }
        return null
    }
    fun merge(heap: AbstractHeap<Element>){
        elements.addAll(heap.elements)
        buildHeap()
    }
    private fun buildHeap(){
        if(!elements.isEmpty()){
            (count / 2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }

}

class MaxHeap<Element: Comparable<Element>>() : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): kotlin.Int{
        return a.compareTo(b)
    }
}
class MinHeap<Element: Comparable<Element>>() : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): kotlin.Int{
        return b.compareTo(a)
    }
}