object Basics extends App {
    // Run with the "run"-button in the top right or with the shortcut
    // [Ctrl] + [Alt] + [N]
    
    val myName = "Jesper"   // val = constant value
    var myAge: Int = 21      // var = variable

    // Hover over myName and myAge to see their types
    // myName is implicitly a String, and myAge is explicitly an Int
    // Type mentioning is optional (most of the time)
    // Possible types: Int, Boolean, Char, Double, Float, String

    // String addition and formatting
    val myFullName = myName + " Norsted"
    var longString = s"My name is $myFullName and i am $myAge years old!"
    


    // Expressions are anything that will be reduced to something
    var expression = 2 + 5 // in this case: the Int 7

    // Statements/instructions do not reduce to something, they just do stuff
    println(longString)
    // --> My name is Jesper Norsted and i am 21 years old!

    // !!! Statements do not exist in scala, everything in scala is an expression !!!
    // "statements" like println() return the Unit type, similar to "void" in other languages

    // if-statement is either true or false here
    var ableToDrive = if (myAge >= 18) true else false

    // Chained if-statements are easier to write and read
    var myEducation = 
        if (myAge >= 24) "College"
        else if (myAge > 19) "High school"
        else if (myAge > 16) "Elementary"
        else "No education"

    println(myEducation)
    // --> High school


    
    // Code blocks have local variables and values
    val myBMI = {
        val myHeight = 1.72
        val myWeight = 58

        // Returns are written straight out like this
        myWeight/scala.math.pow(myHeight, 2)
        // Note that this division and the pow operation works, even though they take only doubles
    }
    // The compiler figures out the type (Double) of this code block

    println(myBMI)
    // --> 19.60519199567334



    // Functions are made like this (note it's simmilarities to a normal value assignment)
    def BMI(weight: Double, height: Double): Double = weight/scala.math.pow(height, 2)

    // functions can have code blocks in their exprssions
    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else n*factorial(n-1)
    }

    println(BMI(70, 1.75))  // --> 22.857142857142858
    println(factorial(6))   // --> 720



    // In scala, we don't use loops or iteration, but recursion
    // Loops and variables are available, but discouraged
}