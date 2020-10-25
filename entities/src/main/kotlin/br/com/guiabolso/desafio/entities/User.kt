package br.com.guiabolso.desafio.entities

import java.time.LocalDate

class User (private val id: String, val transactions: HashMap<String, List<Transaction>>){
    init {
        if (this.id.toInt() < 10000 || this.id.toInt() > 100000000) {
            throw Exception("ID de usuário inválido")
        }
    }

    fun userHasTransactionInDate(date: String): Boolean {
        return this.transactions.containsKey(date)
    }



}
