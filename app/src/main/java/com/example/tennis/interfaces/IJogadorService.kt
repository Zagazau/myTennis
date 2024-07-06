package ipvc.mytennis.api.interfaces

import com.example.tennis.models.responses.jogadores.CreateJogadorResponse
import com.example.tennis.models.responses.jogadores.DeleteJogadorResponse
import com.example.tennis.models.responses.jogadores.GetAllJogadoresResponse
import com.example.tennis.models.responses.jogadores.GetJogadorByIDResponse
import com.example.tennis.models.responses.jogadores.UpdateJogadorResponse
import mytennis.api.core.RequestResult
import requests.jogador.CreateJogadorRequest
import requests.jogador.UpdateJogadorRequest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IJogadorService {

    @GET("jogadores")
    fun getJogadores(): Call<RequestResult.Success<GetAllJogadoresResponse>>

    @POST("jogadores")
    fun createJogador(@Body body: CreateJogadorRequest): Call<RequestResult.Success<CreateJogadorResponse>>

    @DELETE("jogadores/{id}")
    fun deleteJogador(@Path("id") id: String): Call<RequestResult.Success<DeleteJogadorResponse>>

    @PUT("jogadores/{id}")
    fun updateJogador(@Path("id") id: String, @Body body: UpdateJogadorRequest): Call<RequestResult.Success<UpdateJogadorResponse>>

    @GET("jogadores/{id}")
    fun getJogadorById(@Path("id") id: String): Call<RequestResult.Success<GetJogadorByIDResponse>>
}
