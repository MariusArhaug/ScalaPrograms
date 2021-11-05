object Task2 extends App {

    // a)

    // Takes function (which takes nothing and returns nothing), and returns thread
    def CreateThread(func: () => Unit): Thread = {
        val thread = new Thread {
            override def run() = func()
        }
        thread // returns the thread
    }

    def PrintHelloThreads() = {
        println("Hello, threads!")
    }

    val t1 = CreateThread(PrintHelloThreads)
    t1.start()
    t1.getName()



    // b)

    private var counter: Int = 0
    def IncreaseCounter(): Unit = {
        counter += 1
    }

    def PrintCounter() = {
        println(counter)
    }

    CreateThread(IncreaseCounter).start()
    CreateThread(IncreaseCounter).start()
    CreateThread(PrintCounter).start()
    // It doesn't always print in the same order as "Hello, threads!", but for PrintCounter seems to always print "2"
    // This is probably because println takes longer time to execute than an increment, so it's done last

    // This phenomenon is called nondeterminism
    // It happens because threads switch on and off all the time depending on what the computer is doing in the background



    // c)

    counter = 0 // Reseting the counter
    def IncreaseCounterAtomic(): Unit = this.synchronized { // Now the function is atomic, only 1 will run at any time, making it deterministic
        counter += 1
    }
    
    CreateThread(IncreaseCounterAtomic).start()
    CreateThread(IncreaseCounterAtomic).start() // This will not be able to call the incrementer until the first call is finished
    CreateThread(PrintCounter).start() // Always prints "2"



    // d)

    // Deadlock is when several threads wait for the other to finish before itself can finish, which can result in none of them finishing at all.
    // Deadlock is solved by either reordering the execution so any cyclic dependency is avioded,
    // or by backtracking until a program state before the deadlock happened

    def deadlockExample(): Unit = {
        object objectOne {
            lazy val state = "state one"
            lazy val start = objectTwo.state
        }

        object objectTwo {
            lazy val state = objectOne.state
        }

        objectOne.start
        objectTwo.state
    }
}