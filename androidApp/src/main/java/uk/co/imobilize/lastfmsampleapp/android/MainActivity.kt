package uk.co.imobilize.lastfmsampleapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uk.co.imobilize.lastfmsampleapp.Greeting
import android.widget.TextView
import uk.co.imobilize.lastfmsampleapp.android.home.SearchFragment
import uk.co.imobilize.lastfmsampleapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity(), KoinComponent {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initKoin(true) {
            androidLogger()
            androidContext(this@MainActivity)
        }
        val searchFragment = SearchFragment() //the fragment you want to show
        searchFragment.show(supportFragmentManager, true)

    }
}
