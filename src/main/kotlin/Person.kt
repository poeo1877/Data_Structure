data class Person(
    val name: String,
    val age: Int,
    val isMilitary: Boolean)

object MilitaryPersonComparator : Comparator<Person> {
    override fun compare(o1: Person, o2: Person): Int {
        if(o1.isMilitary && !o2.isMilitary){
            return 1
        }else if(!o1.isMilitary && o2.isMilitary){
            return -1
        } else if (o1.isMilitary && o2.isMilitary){
            return o1.age.compareTo(o2.age)
        }
        return 0
    }
}