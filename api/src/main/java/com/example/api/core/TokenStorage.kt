package com.example.api.core

import java.io.File
import java.io.IOException

class TokenStorage private constructor(private val nomeArquivo: String) {

    // Implementação do padrão Singleton
    companion object {
        @Volatile
        private var instance: TokenStorage? = null

        fun getInstance(nomeArquivo: String): TokenStorage {
            return instance ?: synchronized(this) {
                instance ?: TokenStorage(nomeArquivo).also { instance = it }
            }
        }
    }

    // Métodos para salvar e carregar token
    fun salvarToken(token: String) {
        try {
            val arquivo = File(nomeArquivo)
            arquivo.writeText(token)
            println("Token salvo com sucesso no arquivo $nomeArquivo")
        } catch (e: IOException) {
            println("Ocorreu um erro ao salvar o token no arquivo: ${e.message}")
        }
    }

    fun carregarToken(): String? {
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
}
