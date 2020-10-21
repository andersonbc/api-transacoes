package br.com.guiabolso.desafio.infrastructure

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionsController {

    @GetMapping("/user")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("{id}/transacoes/{ano}/{mes}")
    fun getTransactions (
        @PathVariable id: String,
        @PathVariable ano: String,
        @PathVariable mes: String
    ): ResponseEntity<String> {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("s")
    }

}