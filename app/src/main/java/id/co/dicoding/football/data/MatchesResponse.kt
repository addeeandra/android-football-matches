package id.co.dicoding.football.data

import com.google.gson.annotations.SerializedName

data class MatchesResponse(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)