object Task1a {
    def main(args: Array[String]): Unit = {
        
        val newArray = generateArray()                  // Array(1, 2, 3, ... , 49, 50)
        
        println(sumArray(newArray))                     // 1275
        println(tailRecursiveSumArray(newArray, 0))     // 1275
        print(f(10))                                    // 10th f-number is 55
    }

    def generateArray(): Array[Int] = {
        // Could do it like this:
        // val array = for {i <- 0 to 49} yield i+1
        // but that wouldn't be of type Array[Int], but IndexedSeq[Int]

        val array = new Array[Int](50)

        for (i <- 0 to 49) {
            array(i) = i + 1
        }
        
        return array
    }

    def sumArray(array: Array[Int]): Int = {
        var sum = 0
        for (i <- 0 to array.length-1) {
            sum += array(i)
        }
        return sum
    }

    def tailRecursiveSumArray(array: Array[Int], accumulator: Int): Int = {
        if (array.length == 1) return accumulator + array(0)
        tailRecursiveSumArray(array.drop(1), accumulator + array(0))
    }

    // Just f because i can't spell fibbonachi

    // BigInt is probably allocated more memory, even more than Long, so it can store larger numbers
    def f(n: Int): BigInt = if (n < 2) n else f(n-1) + f(n-2)
}