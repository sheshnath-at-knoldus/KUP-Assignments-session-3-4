import scala.collection.mutable.Map
import scala.util.Random


case class Transaction (transactionId : Long ,accountNumber : Long ,transactionType :String,amount :Double)


class BankingApplication {

  //Global storage for AccountDetails
  val accountDetails : Map[Long ,Double]= Map()


  def createAccount(openingBalance :Double) :Map[Long,Double]={
    val random = new Random()
    val balance =openingBalance
    val accountNumber = random.nextLong(999999999999999L)
    if(balance==0.0) throw new IllegalArgumentException("Opening balance cannot be zero")
    accountDetails.addOne( accountNumber,balance)
    accountDetails
  }


  def listAccount() :Map[Long, Double] ={
    accountDetails
  }


  def fetchAccountBalance(accountNumber:Long):Double =  {
    if (!accountDetails.contains(accountNumber)) {
      throw new NoSuchElementException(s"Account with account number $accountNumber does not exist.")
    }
    val balance : Double = accountDetails(accountNumber)
    balance
  }


  def updateBalance(transactions: List[Transaction]): Map[Long, Double] = {
      transactions.map( transaction => {
      val transactionAmount = transaction.amount
      val accountNumber = transaction.accountNumber
      val accountBalance :Double = accountDetails(accountNumber)
      transaction.transactionType match{
        case "Credit" => accountDetails+=(accountNumber->(transactionAmount+accountBalance))
        case "Debit" => accountDetails+=(accountNumber->(accountBalance-transactionAmount))
        case _ => accountDetails
      }
    })
    accountDetails
  }


  def deleteAccount(accountNumber: Long): Boolean = {
     try {
       accountDetails.remove(accountNumber)
     }catch {
       case ex :Exception =>
         println(s"Error in deleteAccount: ${ex.getMessage}")
     }
    if(accountDetails.contains(accountNumber))
      false
    else {
      true
    }
  }

}
