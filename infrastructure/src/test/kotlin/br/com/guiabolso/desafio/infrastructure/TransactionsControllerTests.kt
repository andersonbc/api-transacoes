package br.com.guiabolso.desafio.infrastructure


import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


//@ComponentScan("br.com.guiabolso.desafio.infrastructure.**")
@SpringBootTest( classes = [TransactionsController::class])
@AutoConfigureMockMvc
class TransactionsControllerTests(
    @Autowired val mvc: MockMvc
) {

    @Test
    fun `should return status 200 for transaction`() {
        mvc.perform(get("/10/transacoes/1/10"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return Content-type application json`() {
        mvc.perform(get("/10/transacoes/1/10"))
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

}
