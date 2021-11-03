object Testing {
    def main(args: Array[String]): Unit = {

        var i = 0

        /*
        while (i <= 10) {
            println(i)
            i += 1
        }
        */

        val a = 10
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        for (i <- 0 until a) {
            print(i)
        }

        println()

        for (i <- 0 until alphabet.length) {
            print(alphabet(i)) // Note: not square brackets for arrays
        }


        println()

        var list = for {
            i <- 1 to 5
        } yield scala.math.pow(i, 2)

        var increase = (x: Double) => x + 1
        list.map((x) => increase(x))

        println(list)


        var newArray = list.drop(1)
        print(newArray(0))


    }
}