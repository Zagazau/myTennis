package ipvc.mytennis.api.interfaces

import com.example.tennis.models.responses.users.DeleteUserResponse
import com.example.tennis.models.responses.users.GetAllUsersResponse
import com.example.tennis.models.responses.users.GetUserByIDResponse
import com.example.tennis.models.responses.users.PatchUserResponse
import mytennis.api.core.RequestResult
import requests.user.FindUserRequest
import requests.user.PatchUserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface IUserService {

    @GET("users")
    fun getUsers(): Call<RequestResult.Success<GetAllUsersResponse>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: String): Call<RequestResult.Success<GetUserByIDResponse>>

    @PATCH("users/{id}")
    fun patchUser(@Path("id") id: String, @Body body: PatchUserRequest): Call<RequestResult.Success<PatchUserResponse>>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: String): Call<RequestResult.Success<DeleteUserResponse>>
}
