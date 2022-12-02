import javax.print.attribute.standard.Destination

class Visit<T>(val type: VisitType, val edge: Edge<T>? = null)
enum class VisitType{   //시작 vertex와 아닌 것을 구분하기 위함...
    START,
    EDGE
}

class Dijkstra<T>(private val graph: AdjacencyList<T>){
    private fun route(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): ArrayList<Edge<T>>{
        var vertex = destination
        val path = arrayListOf<Edge<T>>()   //현재까지 가장 shortest path라 생각하는 것이 들어있는 변수. 알고리즘 상 하나의 row
        loop@ while (true) {
            val visit = paths[vertex] ?: break
            when(visit.type){
                VisitType.EDGE -> visit.edge?.let{
                    path.add(it)
                    vertex = it.source
                }
                VisitType.START -> break@loop
            }
        }
        return path
    }

    private fun distance(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): Double{
       //현재 상황(path)에서, source ~> destination 까지 sum(weight) return
        val path = route(destination, paths)
        return path.sumOf{it.weight ?: 0.0}
    }

    fun shortestPath(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): ArrayList<Edge<T>>{
        //table에서 마지막 row를
        return route(destination, paths)
    }
    fun shortestPath(start: Vertex<T>): HashMap<Vertex<T>, Visit<T>>{
        val paths: HashMap<Vertex<T>, Visit<T>> = HashMap()
        paths[start] = Visit(VisitType.START)
        val distanceComparator = Comparator<Vertex<T>>{first, second ->
            (distance(second, paths)-distance(first, paths)).toInt()}   //현재까지의... second vertex의 weight 합과, first vertex의 weight 합의 차
        val priorityQueue = PriorityQueue(distanceComparator)
        priorityQueue.enqueue(start)    //위에 빼기 순서로 인해 MinHeap 기반의 PriorityQueue가 된다

        while(true){    //while문 반복 == 알고리즘 상 step 반복
            val vertex = priorityQueue.dequeue()?:break //지금까지 queue에서 가장 weight 합이 작은 vertex를 꺼내고 아니면 break
            val edges = graph.edges(vertex)
            edges.forEach {
                val weight = it.weight ?: return@forEach
                if(paths[it.destination] == null||distance(vertex, paths)+weight<distance(it.destination, paths)){
                    //해당 path table에서 value가 null이거나, 상황이 변해 어떤 vertex로 가는 weight가 더 짧은 path가 존재할 때
                    paths[it.destination]=Visit(VisitType.EDGE, it)
                    priorityQueue.enqueue(it.destination)
                }
            }
        }
        return paths
    }



}