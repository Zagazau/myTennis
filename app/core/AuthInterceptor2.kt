import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor2 : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = TokenStorage.getInstance().getToken()
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $token")
            .build()
        return chain.proceed(request)
    }
}

