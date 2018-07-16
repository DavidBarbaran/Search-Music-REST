package davidbarbaran.searchmusicrest.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private lateinit var retrofit: Retrofit
    private const val urlBase = "https://www.googleapis.com/youtube/v3/"

    fun instanceClient(): Retrofit {
        retrofit = Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}