class RingBuffer<Element>(val size:Int){
    private var elements = arrayOfNulls<Any>(size)
    private var read_point=0
    private var write_point = 0
    var count: Int = 0
        private set

    //맨 앞이 null인지 어떠한 element 인지 return
    fun first(): Element? {
        if (count > 0)
            return elements.get(read_point) as Element
        return null
    }

    fun write(element: Element):Boolean { //함수 결과가 잘 됬나 안 됬나를 bool로 표현
        if(count >= size)
            return false
        elements.set(write_point, element)  //write_point라는 index에 element라는 값을 집어 넣으라는 말
        count+=1
        write_point = if(write_point + 1 >= size) 0 else write_point +1 //write_point+1가 원래 지정한 size보다 더 커지는 경우 write point를 다시 제일 앞 index로 보내는 행위
        return true
    }
    fun read():Element? {
        if(count <= 0)
            return null
        var ret:Element = elements.get(read_point) as Element
        read_point = if(read_point + 1 >= size) 0 else read_point+1
        count -= 1
        return ret
    }

    override fun toString(): String {
        var ret = "["
        var tmp_read_point = read_point
        var tmp_count = count
        while(tmp_count> 0){
            ret +=" ${elements.get(tmp_read_point)as String}"
            tmp_read_point += 1
            if(tmp_read_point+1 > size)
                tmp_read_point = 0
            tmp_count -= 1
        }
        ret += " ]"
        return ret
    }
}