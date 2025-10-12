/**
 * DAA - labo2
 * Auteurs : Bleuer Rémy, Changanaqui Yoann, Rajadurai Thirusan
 * Date : 03.10.2025
 * Description : Affiche deux fragments (CounterFragment et ColorFragment) dans une activité
 */
package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.iict.daa.labo2.R
import ch.heigvd.iict.daa.template.fragments.ColorFragment
import ch.heigvd.iict.daa.template.fragments.CounterFragment

class MainActivityFragment1 : AppCompatActivity() {
    /**
     * Initialise l'activité et ajoute les deux fragments dans leurs conteneurs respectifs
     * @param savedInstanceState État sauvegardé de l'activité
     */
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
