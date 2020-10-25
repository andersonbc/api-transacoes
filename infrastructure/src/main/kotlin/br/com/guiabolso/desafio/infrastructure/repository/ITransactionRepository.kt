package br.com.guiabolso.desafio.infrastructure.repository

import br.com.guiabolso.desafio.entities.Transaction



interface ITransactionRepository {
    fun findTransactionUserByDate(id: String, ano: String, mes: String) : List<Transaction>
}
