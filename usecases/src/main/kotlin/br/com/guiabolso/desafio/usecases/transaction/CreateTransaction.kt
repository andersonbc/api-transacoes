package br.com.guiabolso.desafio.usecases.transaction

import br.com.guiabolso.desafio.entities.Transaction
import br.com.guiabolso.desafio.entities.User
import java.util.*
import kotlin.random.Random
import java.util.concurrent.ThreadLocalRandom
import java.time.LocalDate
import kotlin.collections.HashMap


class CreateTransaction {
    private val minValueForTransaction = -9999999
    private val maxValueForTransaction = 9999999

    fun generateRandomValue(): Int {
        return Random.nextInt(minValueForTransaction, maxValueForTransaction)
    }

    fun generateRandomDate(startInclusive: LocalDate, endExclusive: LocalDate): Long {
        val minDay = startInclusive.toEpochDay()
        val maxDay = endExclusive.plusDays(1).toEpochDay()
        return  ThreadLocalRandom.current().nextLong(minDay, maxDay)
    }

    fun generateRandomReadableDescription(): String {
        val vowels = arrayOf("a", "e", "i", "o", "u")
        val consonants = arrayOf(
            "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"
        )

        val minLength = 10
        val maxLength = 60-1
        var randomString = ""

        while (randomString.length < maxLength) {
            randomString += consonants.random() + vowels.random()
            if ((Random.nextInt(0, 4) == 0 && randomString.length < 60)) {
                randomString += " "
                if(randomString.length > minLength && Random.nextInt(0, 6) == 0) return randomString
            }
        }
        return randomString
    }


    fun createTransactionsInMonth(date: String): List<Transaction> {
        val parsedDate = LocalDate.parse(date)
        val transactions = mutableListOf<Transaction>()
        this.createTransactions(transactions, parsedDate)
        this.createDuplicatedTransaction(transactions, parsedDate)
        return transactions
    }

    private fun createTransactions(transactions: MutableList<Transaction>, parsedDate: LocalDate) {
        val numberOfTransactions = Random.nextInt(1, 100)
        for (i in 0..numberOfTransactions) {
            transactions.add(
                Transaction(
                    this.generateRandomReadableDescription(),
                    this.generateRandomDate(
                        parsedDate.withDayOfMonth(1),
                        parsedDate.withDayOfMonth(parsedDate.lengthOfMonth())
                    ),
                    this.generateRandomValue(),
                    false
                )
            )
        }
    }

    private fun createDuplicatedTransaction(transactions: MutableList<Transaction>, parsedDate: LocalDate) {
        val mustHaveDuplicateTransaction = Random.nextInt(0, 3) != 0
        if(mustHaveDuplicateTransaction) {
            val numberOfDuplicateTransactions = Random.nextInt(2, 5)

            val description = this.generateRandomReadableDescription()
            val date = this.generateRandomDate(
                parsedDate.withDayOfMonth(1),
                parsedDate.withDayOfMonth(parsedDate.lengthOfMonth())
            )
            val value = this.generateRandomValue()

            for (i in 0 .. numberOfDuplicateTransactions) {
                transactions.add(
                    Transaction(
                        description,
                        date,
                        value,
                        i != numberOfDuplicateTransactions
                    )
                )
            }
        }
    }

}
