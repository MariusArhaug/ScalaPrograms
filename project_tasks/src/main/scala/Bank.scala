class Bank(val allowedAttempts: Integer = 3) {

    private val transactionsQueue: TransactionQueue = new TransactionQueue()
    private val processedTransactions: TransactionQueue = new TransactionQueue()

    def addTransactionToQueue(from: Account, to: Account, amount: Double): Unit = {
        // TODO
        
        val transaction = new Transaction(transactionsQueue, processedTransactions, from, to, amount, allowedAttempts)
        transactionsQueue.push(transaction)

        val transactionThread = spawnThread(processTransactions)
        transactionThread.run
        // create a new transaction object and put it in the queue
        // spawn a thread that calls processTransactions
    }
    private def processTransactions: Unit = {
        // TODO
        // project task 2
        // Function that pops a transaction from the queue
        // and spawns a thread to execute the transaction.
        // Finally do the appropriate thing, depending on whether
        // the transaction succeeded or not
        if (transactionsQueue.isEmpty) return

        val transaction = transactionQueue.pop()

        if (transaction.status == PENDING) {
            transactionsQueue.push(transaction)
            processTransactions()
        }

        val thread = spawnThread(transaction.doTransaction)

        thread.run


    }

    private def spawnThread(f: () => Unit): Thread = {
        new Thread {
            override def run() = f()
        }
    }

    def addAccount(initialBalance: Double): Account = {
        new Account(this, initialBalance)
    }

    def getProcessedTransactionsAsList: List[Transaction] = {
        processedTransactions.iterator.toList
    }

}
