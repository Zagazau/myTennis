package com.example.tennis.models.responses.jogadores

import Jogador

data class GetAllJogadoresResponse(
    val jogadores: List<Jogador>
)