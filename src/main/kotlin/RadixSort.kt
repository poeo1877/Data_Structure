import java.security.KeyStore.TrustedCertificateEntry
import java.lang.Math.pow

fun MutableList<Int>.radixSort(){
    val base = 10
    var done = false
    var digits = 1
    while(!done){
        done = true
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for(i in 0..9){
                this.add(arrayListOf())
            }
        }
        this.forEach{
                number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)
            if(remainingPart > 0){
                done = false
            }
        }
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}


fun Int.digits(): Int {
    var count = 0
    var num = this
    while(num != 0){
        count += 1
        num /= 10
    }
    return count
}

fun Int.digit(atPosition: Int): Int?{
    if(atPosition > digits())return null
    var num = this
    val correctedPosition = (atPosition + 1).toDouble()
    while(num/(pow(10.0, correctedPosition).toInt())!=0){
        num /= 10
    }
    return num % 10
}

private fun msdRadixSorted(list: MutableList<Int>, position: Int): MutableList<Int>{
    if(position > list.maxDigits()) return list         //item 중 가장 큰 값의 digit보다 더 클 경우 그냥 list 반환. 

    val buckets = arrayListOf<MutableList<Int>>().apply{
        for(i in 0..9){
            this.add(arrayListOf())
        }
    }
    val priorityBucket = arrayListOf<Int>()
    list.forEach{number ->
        val digit = number.digit(position)
        if(digit == null){      //  223보다 22가 더 앞으로 sort되게 하는 부분
            priorityBucket.add(number)
            return@forEach          //다음 번 forEach가 작동되게 하는 것
        }
        buckets[digit].add(number)
    }
    priorityBucket.addAll(
        buckets.reduce { result, bucket ->
        if(bucket.isEmpty())return@reduce result
        result.addAll(msdRadixSorted(bucket, position+1))       //다음 자리(index)에서 정렬한 결과를 result에 붙이는 것
        result
    })
    return priorityBucket
}

fun MutableList<Int>.lexicographicalSort(){
    val sorted = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(sorted)
}
private fun MutableList<Int>.maxDigits():Int{   //maxDigits은 가장 큰 숫자의 가장 큰 digit을 의미한다.
    return this.maxOrNull()?.digits()?:0
}