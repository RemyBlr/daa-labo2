package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.labo2.R
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment

class MainActivityFragment1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment1)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.counter_fragment_container, CounterFragment.newInstance())
                .add(R.id.color_fragment_container, ColorFragment.newInstance())
                .commit()
        }
    }
}

