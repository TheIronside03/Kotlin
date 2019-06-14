import java.lang.IllegalArgumentException
import javax.naming.Name

fun main(args: Array<String>) {

    //------ Variables ------
    // Kotlin uses type inference, but you can define the type
    println()
    println("------ Variables ------")

    var bigInt: Int = Int.MAX_VALUE
    var smallInt: Int = Int.MIN_VALUE

    println("Biggest Int : " + bigInt)
    println("Smallest Int : " + smallInt)

    var bigLong: Long = Long.MAX_VALUE
    var smallLong: Long = Long.MIN_VALUE

    println("Biggest Long : " + bigLong)
    println("Smallest Long : " + smallLong)

    var bigDouble: Double = Double.MAX_VALUE
    var smallDouble: Double = Double.MIN_VALUE

    println("Biggest Double : " + bigDouble)
    println("Smallest Double : " + smallDouble)

    var bigFloat: Float = Float.MAX_VALUE
    var smallFloat: Float = Float.MIN_VALUE

    println("Biggest Float : " + bigFloat)
    println("Smallest Float : " + smallFloat)

    // Doubles are normally precise to 15 digits
    var dblNum1: Double = 2.11111111111111111
    var dblNum2: Double = 3.11111111111111111

    println("Sum : " + (dblNum1 + dblNum2))

    /* We also have the following
    Short 16 Bytes
    Byte 8 Bytes
    */

    // Booleans are either true or false
    if (true is Boolean){
        print("true is boolean\n")
    }

    // Characters are single quoted characters
    var letterGrade: Char = 'A'

    println("A is a Char : " + (letterGrade is Char))
    println()


    //------ Casting ------
    println("------ Casting ------")
    println("3.14 to int: ${3.14.toInt()}")
    println("A to int: ${'A'.toInt()}")
    println("69 to character: ${69.toChar()}")
    println()


    //------ Strings ------
    println("------ Strings ------")
    val fName = "Bruce"
    val lName = "Wayne"

    var fullName = "Bruce Wayne"

    println("first name + last name: ${fName+lName}")

    val str1 = "A Random String"
    val str2 = "a Random String"

    println("str1 equals to str2: ${str1 == (str2)}")
    println("check weather str1 contains Random word: ${str1.contains("Random")}")
    println("second index of fName: ${fName[2]}")
    println("sub sequence of str2: ${str2.subSequence(3,9)}")
    println()


    //------ Arrays ------
    println("------ Arrays ------")
    var myArray: Array<Int> = arrayOf(1,3,5)
    for (item in myArray){
        println(item)
    }

    var mixArray = arrayOf(1,3.14,"pi")
    println(mixArray[2])
    println("index of pi: ${mixArray.indexOf("pi")}")

    var sqArray = Array(5,{x-> x*x})
    println("square of 3: ${sqArray[3]}")
    println()


    //------ Ranges ------
    println("------ Ranges ------")
    val OnetoTen = 1..10
    val alphabets = 'A'..'Z'

    println("H in alphabets: ${'H' in alphabets}")

    val reverseNum = 10.downTo(1)
    for (x in reverseNum.reversed()) println(x)
    println("ranges with step 2")
    val rng2 = OnetoTen.step(2)
    for (x in rng2) println(x)
    println()


    //------ Conditionals ------
    println("------ Conditionals ------")
    val age = 10
    if (age<5)
        println("Go to Preeschool")
    else if (age==5)
        println("Go to KinderGarten")
    else if ((age>5) && (age<17)) {
        val grade = age-5
        println("Go to grade: $grade")
    }  else
        println("Go to College")

    when(age){
        in 0..4-> println("Go to Preeschool")
        5-> println("Go to KinderGarten")
        in 5..17-> {
            val grade = age-5
            println("Go to grade: $grade")
        } else-> println("Go to College")
    }
    println()


    //------ Looping ------
    println("------ Looping ------")

    val arrayNum: Array<Int> = arrayOf(3,6,9)

    for (x in arrayNum.indices){
        println("Array nums: ${arrayNum[x]}")
    }

    for ((index,value) in arrayNum.withIndex()){
        println("index: $index value: $value")
    }
    println()


    //------ Functions ------
    println("------ Functions ------")

    fun add(num1:Int,num2:Int) : Int = num1+num2
    println("3 + 3: ${add(3,3)}")

    fun subtract(num1:Int = 1,num2:Int = 1) : Int {
        return num1-num2
    }
    println("3 - 1 : ${subtract(3,1)}")
    println("4 - 5 : ${subtract(num2 = 5,num1 = 4)}")

    fun sayHello(name: String): Unit = println("Hello $name")
    println(sayHello("Kotlin"))

    fun nextTwo(num:Int): Pair<Int,Int>{
        return Pair(num+1,num+2)
    }

    val (two,three) = nextTwo(1)
    println("1 $two $three")

    fun getSum(vararg nums: Int): Int {
        var sum = 0
        nums.forEach { n-> sum+=n }
        return sum
    }

    println("Sum of 1 to 5: ${getSum(1,2,3,4,5)}")

	val multiply = {num1: Int,num2: Int-> num1*num2}
    println("4*3: ${multiply(4,3)}")

    fun fact(x: Int): Int {
        tailrec fun factTail(y: Int,z: Int): Int {
            if (y==0) return z
            else return factTail(y-1 ,y*z)
        }
        return factTail(x,1)
    }

    println("5! = ${fact(5)}")
    println()


    //------ High order Functions ------
    println("------ High order Functions ------")
    val numValues = 1..20
    val evenList = numValues.filter { it % 2 == 0 }
    evenList.forEach { n-> println(n) }

    fun makeMathFun(num1: Int): (Int) -> Int = {num2 -> num1*num2}

    val mult3 = makeMathFun(3)
    println("5 * 3: ${mult3(5)}")
    println()


    //------ Collection operators ------
    println("------ Collection operators ------")
    val numList = 1..20

    val listSum = numList.reduce{ x,y -> x+y }
    println("Reduce sum: $listSum")

    val listSum2 = numList.fold(3){ x,y -> x+y }
    println("Reduce sum: $listSum2")

    println("Evens: ${ numList.any { it%2 == 0 } }")
    println("Evens: ${ numList.all { it%2 == 0 } }")

    val big3 = numList.filter { it > 3 }
    big3.forEach { n-> println(">3: $n") }

    val times7 = numList.map { it*7 }
    times7.forEach { n-> println("*7: $n") }
    println()


    //------ Exception handling ------
    println("------ Exception handling ------")

    val divisor = 0
    try {
        if (divisor == 0){
            throw IllegalArgumentException("can't divide by zero")
        }else {
            println("5/$divisor : ${5/divisor}")
        }
    }catch (e: IllegalArgumentException){
        println("${e.message}")
    }
    println()


    //------ Lists ------
    println("------ Lists ------")
    val list1: MutableList<Int> = mutableListOf(1,2,3,4,5)
    list1.add(6)
    list1.forEach { n-> println(n) }
    list1.removeAt(0)
    println("First: ${list1.first()}")
    println("last: ${list1.last()}")
    println("Second: ${list1[3]}")
    val list3 = list1.subList(0,3)
    list3.clear()
    list1.forEach { n-> println(n) }
    println()


    //------ Maps ------
    println("------ Maps ------")
    val map = mutableMapOf<Int,Any?>()
    val map2 = mutableMapOf(1 to "cool!",2 to 25)

    map[1] = "the happy"
    map[2] = 3

    println("Map size: ${map.size}")
    map.put(3,"things")

    map.remove(2)

    for((x,y) in map) {
        println("Key: $x Value: $y")
    }
    println()


    //------ Classes ------
    println("------ Classes ------")
    val bowser = Animal("Bowser",20.0,11.5)
    bowser.getInfo()

    val spot = Dog("Spot",11.3,10.5,"Bruce Wayne")
    spot.getInfo()





}


open class Animal(val name:String,
                  val height: Double,
                  val weight: Double){

    init {
        val regex = Regex(".*\\d+.*")

        require(!name.matches(regex)){ "Animal can't contain numbers" }

        require(height>0) { "height must be greater than 0" }
        require(weight>0) { "weight must be greater than 0" }


    }

    open fun getInfo(): Unit{
        println("$name is $height tall and weighs $weight")
    }
}

class Dog(name: String,
          height: Double,
          weight: Double,
          var owner: String): Animal(name,height,weight){
    override fun getInfo(): Unit{
        println("$name is $height tall and weighs $weight and is owned by $owner")
    }
}
