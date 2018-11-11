package id.co.dicoding.football.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.co.dicoding.football.R
import id.co.dicoding.football.ui.matches.MatchesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nextFragment = MatchesFragment().apply { setType("next") }
        val pastFragment = MatchesFragment().apply { setType("past") }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content_main, nextFragment)
            .commit()
    }
}
