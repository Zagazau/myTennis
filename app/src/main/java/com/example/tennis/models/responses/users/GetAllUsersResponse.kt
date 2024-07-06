package com.example.tennis.models.responses.users

import User

data class GetAllUsersResponse(
    val users: List<User>
)