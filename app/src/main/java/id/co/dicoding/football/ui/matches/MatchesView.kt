package id.co.dicoding.football.ui.matches

import id.co.dicoding.football.data.EventsItem

interface MatchesView {

    fun showLoading()

    fun hideLoading()

    fun showPlaceholder()

    fun hidePlaceholder()

    fun showMatches(matches: List<EventsItem>)

}