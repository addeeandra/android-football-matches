package id.co.dicoding.football.ui.matches

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.co.dicoding.football.R
import id.co.dicoding.football.data.EventsItem
import kotlinx.android.synthetic.main.fragment_matches.*
import id.co.dicoding.football.ui.matches.adapter.MatchesAdapter

class MatchesFragment : Fragment(), MatchesView {

    private val mPresenter by lazy { MatchesPresenter(this) }

    private var mType = "next"

    fun setType(type: String) {
        mType = type
    }

    override fun showLoading() {
        clp_matches.show()
        rv_matches.visibility = View.GONE
        tv_matches_placeholder.visibility = View.GONE
    }

    override fun hideLoading() {
        clp_matches.hide()
    }

    override fun showPlaceholder() {
        hideLoading()
        tv_matches_placeholder.visibility = View.VISIBLE
    }

    override fun hidePlaceholder() {
        tv_matches_placeholder.visibility = View.GONE
    }

    override fun showMatches(matches: List<EventsItem>) {
        hideLoading()

        with(rv_matches) {
            visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(activity)
            adapter = MatchesAdapter(matches)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_matches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPresenter.fetchMatches(mType)
    }

}