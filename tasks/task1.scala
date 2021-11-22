object Task1 {

  implicit class ChainOps[A](val value : A) extends AnyVal {
    def |>[B](f: A => B): B = f(value)
  }

  /** Main function to launch program **/
  def main(args: Array[String]): Unit = {
    val array = generateArray(50)
    
    printArray(array)

    val forSum = sumArray(array)
    val functionalSum = sumArray2(array)
    val recursionSum = sumArray3(array)
    val tailRecursionSum = sumArray4(array)

    val printString = s"For sum: $forSum | Functional: $functionalSum | Recursion: $recursionSum | Tail Recursion $tailRecursionSum"
    println(printString)
  }

  def printArray[T:Manifest](array: Array[T]) = println(array.mkString(" "))
  
  /** Task 1 **/

  // a) Both functional and for loop way  
  
  // For loop way
  def generateArray(size: Int) = {
    val array = new Array[Int](50)
    for (i <- 1 to 50) array(i-1) = i
    array 
  }

   // Functional way
  def generateArray2(size: Int) = new Array[Int](size).zipWithIndex.map { case (e, i) => i+1} 

  // b) Both functional and for loop way 

  def sumArray(array: Array[Int]): Int = {
    var sum = 0 
    for (i <- 0 to array.length-1) sum += array(i)
    sum
  }

  // Functional way
  def sumArray2(array: Array[Int]): Int = array.reduce((a, b) => a + b)

  // Normal recursive way
  def sumArray3(array: Array[Int]): Int = array(0) + sumArray(array.drop(1))

  // Tail recursion
  def sumArray4(array: Array[Int], acc: Int = 0): Int = if (array.length == 1) acc + array(0) else sumArray4(array.drop(1), acc + array(0)) 
  
  // It seems that BigInt stores up to )2^32)^Integer.MAX_VALUE integers bigger than Long which is a 64 bit integer. 
  // BigInt uses a int[] under the hood (atleast in Java) so the actual size depends on the size of the number you store.
  def getNthFibo(n: Int): BigInt = if (n < 2) n else getNthFibo(n - 1) + getNthFibo(n -2)



}
