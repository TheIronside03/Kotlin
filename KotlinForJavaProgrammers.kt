fun max(vararg numbers: Int) = numbers.reduce {
        max, e-> if(max > e) max else e
}

fun messingWithArray(){
    val names = listOf("Tom","Jerry","Spike")
    for (index in names.indices){
        println("$index : ${names.get(index)}")
    }
}

fun process(input: Any){
    when(input){
        1-> println("you got one!")
        3,4-> println("you got 3 or 4")
        in 12..18-> println("Teen")
        is String-> println("you got ${input.length}")
    }
}

fun nickName(name: String): String?{
    if (name == "Robert")
        return "Iron man"
    return null
}

fun functionalStyle(){
    val double = {e:Int-> e*2}

    listOf(1,2,3,4,5,6)
        .filter { e-> e%2 == 0 }
        .map(double)
        .forEach { e-> println(e) }
}

fun extensionMethod(){
    fun String.shout() = toUpperCase()

    val greet = "Hello"
    println(greet.shout())
}

class Car {
    var yearOfRegistration = 2013
        set(value) {
            if (value > 2020)
                throw RuntimeException("not in the future") as Throwable
            field = value
        }
    companion object {
        fun kind() { println("kind called ...") }
    }

}

object Util {
    fun getNumberOfCore() = 4
}

//Delegation
fun compute(n: Int): Int{
    println("compute called ...")
    return n
}

//Fluency
class Pizza {
    infix fun spread(item: String){
        println("spread $item")
    }
}

fun main(args: Array<String>) {
    println("Hello, There!")
}
