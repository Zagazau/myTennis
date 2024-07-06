package com.example.tennis.interfaces

import com.example.tennis.models.responses.jogos.CreateJogosResponse
import com.example.tennis.models.responses.jogos.DeleteJogosResponse
import com.example.tennis.models.responses.jogos.GetAllJogosResponse
import com.example.tennis.models.responses.jogos.GetJogosByIDResponse
import com.example.tennis.models.responses.jogos.UpdateJogosResponse
import mytennis.api.core.RequestResult
import requests.jogo.CreateJogoRequest
import requests.jogo.UpdateJogoRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IJogoService {

    @GET("jogos")
    fun getJogos(): Call<RequestResult.Success<GetAllJogosResponse>>

    @POST("jogos")
    fun createJogo(@Body body: CreateJogoRequest): Call<RequestResult.Success<CreateJogosResponse>>

    @DELETE("jogos/{id}")
    fun deleteJogo(@Path("id") id: String): Call<RequestResult.Success<DeleteJogosResponse>>

    @PUT("jogos/{id}")
    fun updateJogo(@Path("id") id: String, @Body body: UpdateJogoRequest): Call<RequestResult.Success<UpdateJogosResponse>>

    @GET("jogos/{id}")
    fun getJogoById(@Path("id") id: String): Call<RequestResult.Success<GetJogosByIDResponse>>
}
