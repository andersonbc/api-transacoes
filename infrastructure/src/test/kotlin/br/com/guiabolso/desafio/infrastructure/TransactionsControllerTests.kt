package br.com.guiabolso.desafio.infrastructure


import br.com.guiabolso.desafio.entities.Transaction
import br.com.guiabolso.desafio.infrastructure.repository.TransactionMemoryRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.boot.test.mock.mockito.MockBean

import org.mockito.ArgumentMatchers.same
import org.mockito.Mockito


//@ComponentScan("br.com.guiabolso.desafio.infrastructure.**")
@SpringBootTest(classes = [TransactionsController::class, TransactionMemoryRepository::class])
@AutoConfigureMockMvc
class TransactionsControllerTests(
    @Autowired val mvc: MockMvc,
    @MockBean val transactionMemoryRepository: TransactionMemoryRepository
) {

    @Test
    fun `should return status 200 for transaction`() {
        Mockito.`when`(this.transactionMemoryRepository.findTransactionUserByDate("10001", "2010", "11"))
            .thenReturn(listOf(
                Transaction("teste2", 5454554, 10, false),
                Transaction("teste2", 5454554, 10, false),
                Transaction("teste3", 5454554, 10, true)
            ))
        mvc.perform(get("/10/transacoes/2010/11"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return Content-type application json`() {
        Mockito.`when`(this.transactionMemoryRepository.findTransactionUserByDate("10001", "2010", "11"))
            .thenReturn(listOf(
                Transaction("teste2", 5454554, 10, false),
                Transaction("teste2", 5454554, 10, false),
                Transaction("teste3", 5454554, 10, true)
            ))
        mvc.perform(get("/10/transacoes/1/10"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }
}
