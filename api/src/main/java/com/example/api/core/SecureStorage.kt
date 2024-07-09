package com.example.api.core

import android.content.Context
import java.io.File
import java.io.IOException

// Função para salvar o token em um arquivo
fun salvarTokenEmArquivo(token: String, nomeArquivo: String) {
    try {
        val arquivo = File(nomeArquivo)
        arquivo.writeText(token)
        println("Token salvo com sucesso no arquivo $nomeArquivo")
    } catch (e: IOException) {
        println("Ocorreu um erro ao salvar o token no arquivo: ${e.message}")
    }
}

// Função para carregar o token de um arquivo
fun carregarTokenDeArquivo(nomeArquivo: String): String? {
    return try {
        val arquivo = File(nomeArquivo)
        if (arquivo.exists()) {
            arquivo.readText()
        } else {
            println("Arquivo $nomeArquivo não encontrado.")
            null
        }
    } catch (e: IOException) {
        println("Ocorreu um erro ao carregar o token do arquivo: ${e.message}")
        null
    }
}

// Exemplo de uso das funções
fun main() {
    val nomeArquivo = "token.txt"

    // Simulação de um token obtido após o login
    val token = "seu_token_aqui"

    // Salvar o token em um arquivo
    salvarTokenEmArquivo(token, nomeArquivo)

    // Carregar o token de um arquivo
    val tokenCarregado = carregarTokenDeArquivo(nomeArquivo)
    println("Token carregado do arquivo: $tokenCarregado")
}
