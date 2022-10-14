class Trie<Key>{
    private val root = TrieNode<Key>(key = null, parent=null)

    fun insert(list: List<Key>){
        var current = root
        list.forEach{ element ->
            if (current.children[element]==null){
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating = true
    }

    fun contains(list: List<Key>): Boolean{
        var current = root
        list.forEach{ element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }
    fun remove(collection:List<Key>){
        var current = root
        collection.forEach{
            val child = current.children[it] ?: return
            current = child
        }
        if(!current.isTerminating)return
        current.isTerminating = false
        val parent = current.parent
        while(current.children.isEmpty()&&!current.isTerminating){
            parent?.let{
                it.children[current.key!!]=null
                current = it
            }
        }
    }

}
fun Trie<Char>.insert(string:String){
    insert(string.toList())
}
fun Trie<Char>.contains(string:String):Boolean{
    return contains(string.toList())
}
fun Trie<Char>.remove(string:String){
    remove(string.toList())
}
