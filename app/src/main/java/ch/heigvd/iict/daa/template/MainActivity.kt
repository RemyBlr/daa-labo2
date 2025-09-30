package ch.heigvd.iict.daa.labo2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    // variables that are going to be initialized late
    private lateinit var label: TextView
    private lateinit var button: Button
    private lateinit var editUsernameLauncher: ActivityResultLauncher<Intent>

    private var TAG = "Lifecycle"

    private var FILE = "MainActivity -> "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // depuis android 15 (sdk 35), le mode edge2edge doit être activé
        enableEdgeToEdge()

        // on spécifie le layout à afficher
        setContentView(R.layout.activity_username)

        // comme edge2edge est activé, l'application doit garder un espace suffisant pour la barre système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // la barre d'action doit être définie dans le layout, on la lie à l'activité
        setSupportActionBar(findViewById(R.id.toolbar))

        // get elements in view
        button = findViewById(R.id.editButton)
        label = findViewById(R.id.usernameLabel)

        // contract, after declaaring label
        editUsernameLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val newUsername = result.data?.getStringExtra("username")
                    label.text = "Bienvenue, $newUsername !"
                }
            }

        // listener for button
        button.setOnClickListener {
            val intent = Intent(this, EditUsernameActivity::class.java)
            editUsernameLauncher.launch(intent)
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
        Log.d(TAG, FILE + "nStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, FILE + "onDestroy")
    }
}