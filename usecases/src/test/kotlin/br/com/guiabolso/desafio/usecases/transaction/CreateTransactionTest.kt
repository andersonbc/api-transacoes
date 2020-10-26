package br.com.guiabolso.desafio.usecases.transaction

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate




class CreateTransactionTest {

    @Test
    fun `Should create a random value for transaction between -9999999 and 9999999` () {
        val createTransaction = CreateTransaction()
        for (i in 0 .. 10000) {
            Assertions.assertTrue(createTransaction.generateRandomValue() < 9999999)
            Assertions.assertTrue(createTransaction.generateRandomValue() > -9999999)
        }

    }

    @Test
    fun `Should return startDate or endDate because is an closed range` () {
        val createTransaction = CreateTransaction()
        val startDate = LocalDate.of(2015, 2, 20)
        val endDate = LocalDate.of(2015, 2, 21)
        val generatedDate = createTransaction.generateRandomDate(startDate, endDate)
        val randomDate = LocalDate.ofEpochDay(generatedDate)
        Assertions.assertTrue( (randomDate.compareTo(startDate) == 0) || (randomDate.compareTo(endDate) == 0))
    }

    @Test
    fun `Should create an description with size greater equal 10 and smaller equal 60` () {
        val createTransaction = CreateTransaction()

        for (i in 0 .. 10000) {
            val description = createTransaction.generateRandomReadableDescription()
            Assertions.assertTrue(description.length >= 10)
            Assertions.assertTrue(description.length <= 60)
        }
    }


    @Test
    fun `Should create transaction and in one year at least 3 should be duplicated` () {
        val createTransaction = CreateTransaction()

        for (year in 2010 .. 2100) {
            var totalDuplicates = 0
            for (i in 1..12) {
                val month = if (i < 10) "0${i}" else "$i"
                val transactions = createTransaction.createTransactionsInMonth("${year}-${month}-01")

                if (transactions.any { it.duplicated }) totalDuplicates += 1
            }

            Assertions.assertTrue(totalDuplicates >= 3)
        }
    }


}