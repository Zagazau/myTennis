
const val API_URL: String = "localhost:8080"
open class HttpClient<T>(service: Class<T>) {
    companion object {
        private const val BASE_URL = API_URL + "/api/"
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

    suspend fun <T> request(call: Call<T>): RequestResult<*> {
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
                mapOf())
        }
    }
} */