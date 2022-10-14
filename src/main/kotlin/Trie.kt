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

}