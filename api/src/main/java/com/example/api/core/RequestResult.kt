package com.example.api.core

sealed class RequestResult<out T> {
    data class Success<out T>(val data: T) : RequestResult<T>()
    data class Error(
        val code: Int? = null,
        val message: String? = null,
        val errors: Map<String, String>? = null
    ) : RequestResult<Nothing>()

    companion object {
        fun <T> success(data: T): RequestResult<T> {
            return Success(data)
        }

        fun error(
            code: Int? = null,
            message: String? = null,
            errors: Map<String, String>? = null
        ): RequestResult<Nothing> {
            return Error(code, message, errors)
        }
    }
}

