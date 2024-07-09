package com.example.api.core

import com.example.api.core.AuthInterceptor
import com.example.api.core.RequestResult
import com.example.api.core.ResponseParser
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

const val API_URL: String = "http://localhost:8080"


open class HttpClient<T>(service: Class<T>) {
    companion object {
        private const val BASE_URL = "$API_URL/api/"
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor())
        .build()

    protected var api: T = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(service)

    suspend fun <R> request(call: Call<R>): RequestResult<*> {
        return try {
            val response = call.awaitResponse()
            if (response.isSuccessful) {
                ResponseParser.Success(response)
            } else {
                ResponseParser.Error(response)
            }
        } catch (err: Exception) {
            RequestResult.Error(
                500,
                "API REQUEST FAILED: " + err.message,
                mapOf()
            )
        }
    }
}
