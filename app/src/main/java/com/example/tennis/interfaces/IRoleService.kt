package ipvc.mytennis.api.interfaces

import com.example.tennis.models.responses.roles.GetAllRolesResponse
import com.example.tennis.models.responses.roles.GetRoleByIDResponse
import mytennis.api.core.RequestResult
import requests.role.FindRoleRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IRoleService {

    @GET("roles")
    fun getRoles(): Call<RequestResult.Success<GetAllRolesResponse>>

    @GET("roles/{id}")
    fun getRoleById(@Path("id") id: String): Call<RequestResult.Success<GetRoleByIDResponse>>
}
