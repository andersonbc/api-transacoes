package br.com.guiabolso.desafio.usecases.transaction

import java.util.*
import kotlin.random.Random
import java.util.concurrent.ThreadLocalRandom
import java.time.LocalDate







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

}
