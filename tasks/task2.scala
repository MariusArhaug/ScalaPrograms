import java.util.concurrent.Future
object Task2 {
  def main(args: Array[String]): Unit = {

    val thread = initializeThreadFunction(println("thread function"))
    thread.run
    
    for (i <- 0 to 10) increaseCounterWithThreads()
  }

  /** Task 2 **/

  // a)
  def initializeThreadFunction(f: => Unit): Thread = {
    new Thread(new Runnable {
      def run() = f
    })
    
  }

  // b)
  private var counter: Int = 0
  def increaseCounter(): Unit = {
    counter += 1
  }

  def increaseCounterWithThreads(): Unit = {

    val threadOne = initializeThreadFunction(increaseCounter())
    val threadTwo = initializeThreadFunction(increaseCounter())
    val threadThree = initializeThreadFunction(println(counter))

    threadOne.run
    threadTwo.run
    threadThree.run

  }

  // c)



  // d)
  /**
   *  Deadlock: A deadlock occurs when to or more programs that share the same resource are preventing each other from accessing that resourcen
   **/

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
