fun getGraph(): AdjacencyMatrix<String>{
    val graph = AdjacencyMatrix<String>()
    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFranciso = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Ausin Texas")
    val seattle = graph.createVertex("Seattle")
    graph.add(EdgeType.UNDIRECTED,singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED,singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED,hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED,tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED,tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED,hongKong, sanFranciso, 600.0)
    graph.add(EdgeType.UNDIRECTED,detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED,austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED,sanFranciso, washingtonDC, 337.0)
    graph.add(EdgeType.UNDIRECTED,washingtonDC, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, sanFranciso, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED,austinTexas, sanFranciso, 297.0)
    return graph
}

fun main(){
    val graph = getGraph()
    println(graph)
}