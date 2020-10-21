package br.com.guiabolso.desafio.application


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.HttpStatus

import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ComponentScan( "br.com.guiabolso.desafio.**" )
@AutoConfigureMockMvc
class TransactionsControllerTests(
    @Autowired val restTemplate: TestRestTemplate
) {

    @Test
    fun `Assert blog page title, content and status code`() {

        //mockMvc.perform(get("/10/transacoes/1/10").accept(MediaType.APPLICATION_JSON))
          //  .andExpect(status().isOk)
            //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        val entity = restTemplate.getForEntity<String>("/10/transacoes/1/10")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Blog</h1>")
    }

}
