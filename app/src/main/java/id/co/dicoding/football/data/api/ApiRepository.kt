package id.co.dicoding.football.data.api

import java.net.URL

object ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }

}