package com.example.tennis.repositories

import com.example.api.core.RequestResult
import com.example.api.interfaces.IAuthService
import com.example.api.models.responses.auth.LoginResponse
import com.example.api.models.responses.auth.RegisterResponse
import requests.auth.LoginRequest
import requests.auth.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://localhost:8080")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val authService = retrofit.create(IAuthService::class.java)

    suspend fun register(name: String, email: String, password: String, roleId: String?): RequestResult<RequestResult.Success<RegisterResponse>> {
        val request = RegisterRequest(name, email, password, roleId)
        val response = authService.register(request).execute()
        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                RequestResult.success(body)
            } else {
                RequestResult.error(message = "Register response is empty")
            }
        } else {
            RequestResult.error(message = "Failed to register: ${response.message()}")
        }
    }

    suspend fun login(email: String, password: String): RequestResult<RequestResult.Success<LoginResponse>> {
        val request = LoginRequest(email, password)
        val response = authService.login(request).execute()
        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                RequestResult.success(body)
            } else {
                RequestResult.error(message = "Login response is empty")
            }
        } else {
            RequestResult.error(message = "Failed to login: ${response.message()}")
        }
    }
}

