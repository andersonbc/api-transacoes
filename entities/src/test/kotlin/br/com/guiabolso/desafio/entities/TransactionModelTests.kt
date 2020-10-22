package br.com.guiabolso.desafio.entities


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest()
class TransactionModelTests() {
    @Test
    fun `teste model`() {
        val transaction = Transaction("teste", 21000, 12, true)
        Assertions.assertEquals("teste", transaction.description)
        Assertions.assertEquals(21000, transaction.data)
    }

}
