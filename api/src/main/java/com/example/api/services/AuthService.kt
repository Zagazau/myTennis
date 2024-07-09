package com.example.api.services

import com.example.api.core.RequestResult
import com.example.api.interfaces.IAuthService
import com.example.api.models.responses.auth.LoginResponse
import com.example.api.models.responses.auth.RegisterResponse
import requests.auth.LoginRequest
import requests.auth.RegisterRequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthService {

    private val authService: IAuthService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        authService = retrofit.create(IAuthService::class.java)
    }

    suspend fun login(body: LoginRequest): Call<RequestResult.Success<LoginResponse>> {
        return authService.login(body)
    }

    suspend fun register(body: RegisterRequest): Call<RequestResult.Success<RegisterResponse>> {
        return authService.register(body)
    }

}
