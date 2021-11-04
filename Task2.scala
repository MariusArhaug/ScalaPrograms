object Task2 extends App {

  def initThread (fun: () => Unit): Thread = {
    val thread = new Thread {
      override def run() = fun()
    }
    thread
  }
  def printStart(): Unit = { println ("Started...")}

  initThread(printStart).start()

  private var counter: Int = 0
  def increaseCounter(): Unit = {
    counter += 1
  }

  def printCounter(): Unit = {
    println(counter)
  }

  initThread(increaseCounter).start()
  initThread(increaseCounter).start()
  initThread(printCounter).start()

  def increaseCounterAtomic(): Unit = this.synchronized {
    counter += 1
  }

  initThread(increaseCounterAtomic).start()
  initThread(increaseCounterAtomic).start()
  initThread(printCounter).start()

}
