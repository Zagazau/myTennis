package com.example.tennis.models.responses.roles

import com.example.tennis.models.Role

data class GetAllRolesResponse(
    val roles: List<Role>
)