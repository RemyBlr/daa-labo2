/**
 * DAA - labo2
 * Auteurs : Bleuer Rémy, Changanaqui Yoann, Rajadurai Thirusan
 * Date : 03.10.2025
 * Description : Affiche une entrée de texte et un bouton pour sauvegarder le nom d'utilisateur
 */

package ch.heigvd.iict.daa.labo2

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EditUsernameActivity : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var button: Button
    private var TAG = "Lifecycle"
    private var FILE = "EditUsernameActivity -> "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // depuis android 15 (sdk 35), le mode edge2edge doit être activé
        enableEdgeToEdge()

        // on spécifie le layout à afficher
        setContentView(R.layout.activity_edit_username)

        // comme edge2edge est activé, l'application doit garder un espace suffisant pour la barre système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // la barre d'action doit être définie dans le layout, on la lie à l'activité
        setSupportActionBar(findViewById(R.id.toolbar))

        // get elements in view
        input = findViewById(R.id.usernameField)
        button = findViewById(R.id.saveButton)

        button.setOnClickListener {
            // using intent to return the result to the calling activity
            val resultIntent = intent
            // add the new username to the intent
            resultIntent.putExtra("username", input.text.toString())
            // set result to valid
            setResult(RESULT_OK, resultIntent)
            // finish activity
            finish()
        }

        Log.d(TAG, FILE + "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, FILE + "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, FILE + "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, FILE + "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, FILE + "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, FILE + "onDestroy")
    }
}
