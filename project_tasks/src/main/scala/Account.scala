import exceptions._

class Account(val bank: Bank, initialBalance: Double) {

    class Balance(var amount: Double) {}

    val balance = new Balance(initialBalance)

    // for project task 1.3: change return type and update function bodies
    def withdraw(amount: Double): Either[Unit, String] = {
        if (balance.amount - amount < 0 || amount < 0) { 
            "You cannot withdraw this much!"
        }
        else {
            balance.amount -= amount
        }
        
    }
    def deposit (amount: Double): Either[Unit, String] = {
        if (amount < 0) {
            "You cannot deposit a negative amount"
        } else {
            balance.amount += amount
        }
    }
    def getBalanceAmount: Double       = balance.amount

    def transferTo(account: Account, amount: Double) = {
        bank addTransactionToQueue (this, account, amount)
    }

}
