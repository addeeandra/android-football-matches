package id.co.dicoding.football.ui.matches.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import id.co.dicoding.football.R
import id.co.dicoding.football.data.EventsItem

class MatchesAdapter(private val items: List<EventsItem>) : RecyclerView.Adapter<MatchesViewHolder>() {

    override fun onCreateViewHolder(container: ViewGroup, type: Int): MatchesViewHolder {
        val inflater = LayoutInflater.from(container.context)
        return MatchesViewHolder(inflater.inflate(R.layout.item_match, container, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MatchesViewHolder, position: Int) {
        holder.bind(items[position])
    }

}