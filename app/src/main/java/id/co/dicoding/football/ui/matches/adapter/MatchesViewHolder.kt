package id.co.dicoding.football.ui.matches.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import id.co.dicoding.football.data.EventsItem
import kotlinx.android.synthetic.main.item_match.view.*

class MatchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: EventsItem) {

        with(itemView) {
            tv_date.text = item.strDate
            tv_time.text = item.strTime
            tv_home_name.text = item.strHomeTeam
            tv_away_name.text = item.strAwayTeam
            tv_home_score.text = item.intHomeScore.toString()
            tv_away_score.text = item.intAwayScore.toString()
        }

    }

}