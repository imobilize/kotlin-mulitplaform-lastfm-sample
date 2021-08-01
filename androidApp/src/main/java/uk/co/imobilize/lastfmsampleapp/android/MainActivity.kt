package uk.co.imobilize.lastfmsampleapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uk.co.imobilize.lastfmsampleapp.Greeting
import android.widget.TextView
import uk.co.imobilize.lastfmsampleapp.android.home.SearchFragment

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchFragment = SearchFragment() //the fragment you want to show
        searchFragment.show(supportFragmentManager, true)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
