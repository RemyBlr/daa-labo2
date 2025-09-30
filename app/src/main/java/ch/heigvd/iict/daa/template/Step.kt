package ch.heigvd.iict.daa.template

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ch.heigvd.iict.daa.labo2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val COUNTER = "counter"

/**
 * A simple [Fragment] subclass.
 * Use the [Step.newInstance] factory method to
 * create an instance of this fragment.
 */
class Step : Fragment() {
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            count = it.getInt(COUNTER)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Step.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(count: Int) =
            Step().apply {
                arguments = Bundle().apply {
                    putInt(COUNTER, count)
                }
            }
    }
}