package com.example.tennis.models.responses.jogadores

data class CreateJogadorResponse(
    val id: String,
    val nome: String,
    val nacionalidade: String?
)