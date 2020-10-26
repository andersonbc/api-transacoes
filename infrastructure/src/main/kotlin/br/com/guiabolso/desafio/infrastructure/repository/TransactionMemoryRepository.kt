package br.com.guiabolso.desafio.infrastructure.repository

import br.com.guiabolso.desafio.entities.Transaction
import br.com.guiabolso.desafio.entities.User
import br.com.guiabolso.desafio.usecases.transaction.CreateTransaction
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class TransactionMemoryRepository : ITransactionRepository {
    private val users = HashMap<String, User>()
    private val createTransaction = CreateTransaction()



    override fun findTransactionUserByDate(id: String, ano: String, mes: String): List<Transaction> {

        val date = "${ano}-${mes}-01"
        if(userExist(id)) {
            val user = users[id]!!
            if(!user.userHasTransactionInDate(date)){
                val transactions = createTransaction.createTransactionsInMonth(date)
                user.transactions[date] = transactions
            }
            return user.transactions[date]!!
        }

        val transactions = HashMap<String, List<Transaction>>()
        val listOfTransactions = createTransaction.createTransactionsInMonth(date)
        transactions[date] = listOfTransactions
        val user = User(id, transactions)
        users[id] = user
        return user.transactions[date]!!

    }

    private fun userExist(userId: String): Boolean {
        return this.users.containsKey(userId)
    }



}