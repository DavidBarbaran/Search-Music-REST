package davidbarbaran.searchmusicrest.networking

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoint {

    @GET("search?")
    fun searchSongsYoutube(
            @Query("key") apiKey: String,
            @Query("q") search: String,
            @Query("part") part: String,
            @Query("type") type: String,
            @Query("maxResults") maxResults: Int
        ): Call<JsonObject>
}