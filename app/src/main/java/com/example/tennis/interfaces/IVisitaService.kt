package com.example.tennis.interfaces


import com.example.tennis.models.responses.visitas.CreateVisitaResponse
import com.example.tennis.models.responses.visitas.DeleteVisitaResponse
import com.example.tennis.models.responses.visitas.GetAllVisitasResponse
import com.example.tennis.models.responses.visitas.GetVisitaByIDResponse
import com.example.tennis.models.responses.visitas.UpdateVisitaResponse
import mytennis.api.core.RequestResult
import requests.visitas.CreateVisitaRequest
import requests.visitas.UpdateVisitaRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IVisitaService {

    @GET("visitas")
    fun getVisitas(): Call<RequestResult.Success<GetAllVisitasResponse>>

    @POST("visitas")
    fun createVisita(@Body body: CreateVisitaRequest): Call<RequestResult.Success<CreateVisitaResponse>>

    @DELETE("visitas/{id}")
    fun deleteVisita(@Path("id") id: String): Call<RequestResult.Success<DeleteVisitaResponse>>

    @PUT("visitas/{id}")
    fun updateVisita(@Path("id") id: String, @Body body: UpdateVisitaRequest): Call<RequestResult.Success<UpdateVisitaResponse>>

    @GET("visitas/{id}")
    fun getVisitaById(@Path("id") id: String): Call<RequestResult.Success<GetVisitaByIDResponse>>
}
