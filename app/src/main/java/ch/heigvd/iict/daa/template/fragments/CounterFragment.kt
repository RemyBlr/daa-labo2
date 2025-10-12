/**
 * DAA - labo2
 * Auteurs : Bleuer Rémy, Changanaqui Yoann, Rajadurai Thirusan
 * Date : 03.10.2025
 * Description : Fragment affichant un compteur incrémentable
 */
package ch.heigvd.iict.daa.template.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ch.heigvd.iict.daa.labo2.R

private const val ARG_COUNTER = "param_counter"

class CounterFragment : Fragment() {

    private var counter: Int = 0

    /**
     * Initialise le fragment et récupère le compteur passé en argument
     * @param savedInstanceState État sauvegardé du fragment
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            counter = it.getInt(ARG_COUNTER)
        }
    }

    /**
     * Crée la vue du fragment à partir du layout XML
     * @param inflater Inflateur de layout
     * @param container Conteneur parent
     * @param savedInstanceState État sauvegardé
     * @return La vue créée
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // création de la vue à partir du xml
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    /**
     * Initialise les composants de la vue et configure le bouton d'incrémentation
     * @param view Vue racine du fragment
     * @param savedInstanceState État sauvegardé
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        savedInstanceState?.let {
            counter = it.getInt(ARG_COUNTER, 0)
        }

        // linkage de la GUI
        val counterTv = view.findViewById<TextView>(R.id.f_counter)
        val button = view.findViewById<Button>(R.id.f_counter_increment)

        // initialisation des vues
        counterTv.text = "$counter"

        // évenements
        button.setOnClickListener {
            ++counter
            counterTv.text = "$counter"
        }
    }

    /**
     * Sauvegarde l'état du fragment (la valeur du compteur)
     * @param outState Bundle où sauvegarder l'état
     */
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNTER, counter)
    }

    companion object {
        /**
         * Crée une nouvelle instance du fragment avec une valeur initiale
         * @param counter Valeur initiale du compteur (par défaut 0)
         * @return Une nouvelle instance de CounterFragment
         */
        @JvmStatic
        fun newInstance(counter: Int = 0) =
            CounterFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COUNTER, counter)
                }
            }
    }
}