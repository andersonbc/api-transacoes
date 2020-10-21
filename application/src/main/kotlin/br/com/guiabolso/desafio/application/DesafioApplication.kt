package br.com.guiabolso.desafio.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [ "br.com.guiabolso.desafio.infrastructure" ])
open class DesafioApplication

fun main(args: Array<String>) {
    runApplication<DesafioApplication>(*args)
}
