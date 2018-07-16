package davidbarbaran.searchmusicrest.presenter

import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import davidbarbaran.searchmusicrest.controller.ViewController
import davidbarbaran.searchmusicrest.model.SongYoutube
import davidbarbaran.searchmusicrest.networking.EndPoint
import davidbarbaran.searchmusicrest.networking.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchPresenter constructor(private val viewHome: ViewController.ViewSearch) {

    private val api = RetrofitConfig.instanceClient().create(EndPoint::class.java)

    fun searchSong(search: String) {
        api.searchSongsYoutube("AIzaSyCsMW7oB5txpl6WWtxHCc_OTGfLs11frZI", search,
                "snippet", "video", 2).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
                viewHome.listSong(convertSong(response!!.body()!!.get("items").asJsonArray))
            }

            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {

            }
        })
    }

    private fun convertSong(jsonArray: JsonArray): MutableList<SongYoutube>{
        var list: MutableList<SongYoutube> = mutableListOf()
        for (jsonObject: JsonElement in jsonArray) {
            Log.e("key", jsonObject.asJsonObject.get("id").asJsonObject.get("videoId").asString)
            list.add(SongYoutube(
                    jsonObject.asJsonObject.get("id").asJsonObject.get("videoId").asString,
                    jsonObject.asJsonObject.get("snippet").asJsonObject.get("title").asString,
                    jsonObject.asJsonObject.get("snippet").asJsonObject.get("thumbnails")
                            .asJsonObject.get("high").asJsonObject.get("url").asString
            ))
        }
        return list
    }
}