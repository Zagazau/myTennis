package com.example.tennis.models.responses.jogadores

data class UpdateJogadorResponse(
    val id: String,
    val nome: String,
    val nacionalidade: String?
)