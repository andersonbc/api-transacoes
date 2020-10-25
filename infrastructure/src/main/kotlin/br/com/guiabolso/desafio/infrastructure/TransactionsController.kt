package br.com.guiabolso.desafio.infrastructure

import br.com.guiabolso.desafio.entities.Transaction
import br.com.guiabolso.desafio.infrastructure.repository.TransactionMemoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionsController(
    @Autowired val transactionRepository: TransactionMemoryRepository
) {

    @GetMapping("/user")
    fun blog(): String {
        return "blog"
    }

    @GetMapping("{id}/transacoes/{ano}/{mes}")
    fun getTransactions (
        @PathVariable id: String,
        @PathVariable ano: String,
        @PathVariable mes: String
    ): ResponseEntity<List<Transaction>> {


        val transactions = transactionRepository.findTransactionUserByDate(id, ano, mes)
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(transactions)
    }

}