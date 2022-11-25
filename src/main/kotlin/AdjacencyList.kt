class AdjacencyList<T> : Graph<T>{
    private val adjacencies: HashMap<Vertex<T>,ArrayList<Edge<T>>> = HashMap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex]=ArrayList()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)  //source 인자가 null로 올 수 있으니...
    }

    override fun edges(source: Vertex<T>)=adjacencies[source] ?: arrayListOf()

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull{it.destination == destination}?.weight 
                                /*.firstOrNUll에서 first는 { }안에 있는 condition을 만족하는 것 중 가장 첫번째를 의미
                                  위 조건을 만족하는 것이 없다면 NUll return 하고 찾으면 그것의 weight를 return한다*/ 
    }

    override fun toString(): String {
        return buildString {
            adjacencies.forEach{(vertex, edges) ->
                val edgeString = edges.joinToString{it.destination.data.toString()}
                append("${vertex.data} ---> [ $edgeString ]\n")
            }
        }
    }

}

