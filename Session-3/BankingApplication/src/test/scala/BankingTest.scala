import org.scalatest.funsuite.AnyFunSuite
import scala.collection.mutable


class BankingTest extends AnyFunSuite{

  val bankingAppliactionInstance = new BankingApplication

  test("Test case 1 for create account") {
    val actualValue = bankingAppliactionInstance.createAccount(10000)
    val listAccount = bankingAppliactionInstance.listAccount()
    val accountNumber = listAccount.head
    val expectedValue =mutable.HashMap(accountNumber)
    assert(actualValue===expectedValue)
  }


  test("Test case 2 for list Account "){
   val actualValue = bankingAppliactionInstance.createAccount(10000)
    val expectedValue =bankingAppliactionInstance.listAccount()
    assert(actualValue===expectedValue)
  }


  test("Test case 3 for fetchAccountBalance") {
    val accountList =bankingAppliactionInstance.listAccount()
    val actualValue = bankingAppliactionInstance.fetchAccountBalance(accountList.keys.head)
    val expectedValue =10000.0
    assert(actualValue===expectedValue)
  }


  test("Test case 4 for Transaction "){

    val listaccount =bankingAppliactionInstance.listAccount()
    val caseClassInstance = Transaction(10101L, listaccount.keys.head, "Credit", 10000)
    val transactionList = List(caseClassInstance)
    bankingAppliactionInstance.updateBalance(transactionList)
    val expectedValue = listaccount.values.head
    val actualValue =20000.0
    assert(actualValue===expectedValue)
  }


  test("Test case 5 for Delete the account") {
    bankingAppliactionInstance.createAccount(30000)
    val accountList = bankingAppliactionInstance.listAccount()
    val booleanResultAfterDelete =bankingAppliactionInstance.deleteAccount(accountList.keys.head)
    /*
     deleteAccount() returns boolean value if account deleted it returns true else return false
     */
    val actualValue = true
    val expectedValue =booleanResultAfterDelete
    assert(actualValue===expectedValue)
  }

}
