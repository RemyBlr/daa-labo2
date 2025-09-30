package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ch.heigvd.iict.daa.labo2.R

class MainActivityFragment2 : AppCompatActivity() {
    private var id: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragmentmanager_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    // Either get back to the previous fragment in the stack, or close
    private fun back() {
        supportFragmentManager.popBackStack()
    }

    // Close the activity
    private fun close() {
        supportFragmentManager.popBackStack(
            null,
            androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    // Pile up the current and go to the next fragment
    private fun next() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Step.newInstance(id++))
            .addToBackStack(null)
            .commit()
    }
}