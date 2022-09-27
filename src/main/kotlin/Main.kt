import kotlin.reflect.typeOf

fun main() {
    var list = LinkedList<Int>()
    list.push(value=10).push(value = 20).push(value = 30).push(value=40).push(value=50).push(value=60).push(value=70)

    var s:String =""
    for (item in list)
        s += " -> ${item*10}" //item의 datatype은 int이다. 위에서 list = LinkedList<Int>라고 선언했기 때문

    println(s)
    s=s.substring(4) //마지막에 붙는 ' -> '제거
    println(s)
}




