package com.example.tennis.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api.core.RequestResult
import com.example.api.models.responses.auth.LoginResponse
import com.example.api.models.responses.auth.RegisterResponse
import com.example.tennis.repositories.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val authRepository = AuthRepository()

    private val _registerResult = MutableLiveData<RequestResult<RegisterResponse>>()
    val registerResult: LiveData<RequestResult<RegisterResponse>> = _registerResult

    private val _loginResult = MutableLiveData<RequestResult<LoginResponse>>()
    val loginResult: LiveData<RequestResult<LoginResponse>> = _loginResult

    fun register(name: String, email: String, password: String, roleId: String?) {
        viewModelScope.launch {
            try {
                val response = authRepository.register(name, email, password, roleId)
                _registerResult.value = response
            } catch (e: Exception) {
                _registerResult.value = RequestResult.error(message = e.message ?: "Unknown error")
            }
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.login(email, password)
                _loginResult.value = response
            } catch (e: Exception) {
                _loginResult.value = RequestResult.error(message = e.message ?: "Unknown error")
            }
        }
    }
}
