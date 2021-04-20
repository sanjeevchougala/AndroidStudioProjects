package com.learning.kotlin


fun main(args:Array<String>){
    var person = Person()
    person.name = "Mr X"
    person.age = 38

    println(person.personInfo())


    println("Hello from first kotlin")
    var greet = "hello, Good Morning!"
    var a =1
    var b =10
    var pi = 3.14
    var radius = 10

    var circumference = 2 * pi * radius

    println("circumference is :  $circumference")

    add(a,b)

    var weather = "Cloudy"
    greet("$greet it's $weather")

    println("length : " + greet.length)

    println("compareTo : " + greet.compareTo("compoareTo"))

    println("capitalized : " + greet.capitalize())

    println("De-capitalized : " + greet.decapitalize())

    println("filtered for O: " + greet.filter { char -> char == 'o' })
    println("filtered for non O: " + greet.filter { char -> !char.equals('o') })
    println("count of : " + greet.count { char -> char == 'o' })

    /* Lists and Arrays */
    /* Lists won't allow to update the values where as Array allow to update the values */
    var days = listOf("Sunday", "Monday", "Tuesday", "Wednseday", "Thursday", "Friday", "Saturday")

    println("first day of the week is: " + days[0])
    println("last day of the week is: " + days[6])

    var daysArray = arrayOf("Sunday", "Monday", "Tuesday", "Wednseday", "Thursday", "Friday", "Saturday")
    daysArray[0] = "Ravivar"
    println("first day of the week is: " + daysArray[0])
    println("last day of the week is: " + daysArray[6])

    for(day in daysArray){
        println("day is: $day")
    }

    //print fibonacci series
    var fib = mutableListOf<Int>(0,1)
    for (num in 2..10){
        fib.add(fib[num-1]+fib[num-2])
    }

    println("finb series is: $fib")


    //Mutable list

    var mutList : MutableList<String> = mutableListOf("January", "February")
    mutList.add("March")

    println("Mutlist is $mutList")


    var mutableListofMovies : MutableList<String> = mutableListOf("Movie 1")
    mutableListofMovies.add("Movie3")
    println("mutableListofMovies is $mutableListofMovies")
    mutableListofMovies.add(1,"Movie2")
    println("mutableListofMovies is $mutableListofMovies")
    println("Reversed mutableListofMovies is " + mutableListofMovies.asReversed())

}

fun greet(message:String ){
    println(message)
}

fun add(a:Int,b:Int ){
    println(a+b)
}