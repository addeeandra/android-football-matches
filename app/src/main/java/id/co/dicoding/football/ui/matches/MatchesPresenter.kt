package id.co.dicoding.football.ui.matches

import com.google.gson.Gson
import id.co.dicoding.football.data.EventsItem
import id.co.dicoding.football.data.MatchesResponse
import id.co.dicoding.football.data.api.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MatchesPresenter(private val mView: MatchesView) {

    fun fetchMatches(type: String) {
        GlobalScope.launch(Dispatchers.Main) {

            // tampilin loading
            mView.showLoading()

            // fetch data dari server
            val response = GlobalScope.async {
                ApiRepository
                    .doRequest(
                        "https://www.thesportsdb.com/api/v1/json/1/events$type.php?id=133602"
                    )
            }.await()

            // parsing data
            val result = Gson()
                .fromJson<MatchesResponse>(
                    response, MatchesResponse::class.java
                )

            // tampilkan data
            if (result?.events != null) {
                mView.showMatches(result.events as List<EventsItem>)
            } else {
                mView.showPlaceholder()
            }
        }
    }

}