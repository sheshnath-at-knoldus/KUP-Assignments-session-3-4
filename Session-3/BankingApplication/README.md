BAnking Application


Create a banking application using Map[Long, Double] 
account number -> Long
account balance -> Double
case class Transactions(transactionId: Long, accountNumber: Long, transactionType: String, amount: Double)
Create methods for following operations:

    Create new account by allocating random account number and depositing balance in account

           def createAccount(openingBalance: Double): Map[Long, Double] = ???

    List all accounts with balance

           def listAccounts(): Map[Long, Double] = ???

    Fetch account balance using account number

           def fetchAccountBalance(accountNumber: Long): Double = ???

    You have a list of Transactions having account number, transaction type (credit/debit) and amount. Create a method to update account balance that will take List of Transactions, as per transaction type it will credit or debit amount in account (Use Pattern matching)

           def updateBalance(transactions: List[Transactions]): Map[Long, Int] = ???

    Delete account using account number

           def deleteAccount(accountNumber: Long): Boolean = ???
