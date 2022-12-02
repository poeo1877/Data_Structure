import javax.print.attribute.standard.Destination

interface Graph<T>{
    fun createVertex(data: T):Vertex<T>
    fun addDirectedEdge(source: Vertex<T>,destination: Vertex<T>, weight: Double?)
    fun addUndirectedEdge(source: Vertex<T>,destination: Vertex<T>, weight: Double?){
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }
    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?){
        when(edge){
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    fun edges(source: Vertex<T>):ArrayList<Edge<T>>
    fun weight(source: Vertex<T>,destination: Vertex<T>):Double?



    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>>{
        val queue = LinkedListQueue<Vertex<T>>()    //process
        val enqueued = ArrayList<Vertex<T>>()       //이미 queue에 들어갔던 vertex인지 체크용
        val visited = ArrayList<Vertex<T>>()        //output

        queue.enqueue(source)
        enqueued.add(source)
        while(true){
            val vertex = queue.dequeue()?:break
            visited.add(vertex)
            val neighborEdges = edges(vertex)
            neighborEdges.forEach {
                if(!enqueued.contains(it.destination)){
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }
        }
        return visited
    }


}
enum class EdgeType{
    DIRECTED, UNDIRECTED
}
