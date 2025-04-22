package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import edu.msudenver.cs3013.colorfragments.ColorFragment.Companion.fragmentCount
import android.util.Log

class ColorFragment : Fragment() {
    private var myIndex : Int = 0
    private val chosenColorTV: TextView?
        get() = view?.findViewById(R.id.mycolor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val choiceId = arguments?.getInt("COLOR_CHOICE",0) ?: 0
        Log.d("ColorFragment", "inside onViewCreated. choiceID: $choiceId")
        if (choiceId == 2) {
            chosenColorTV?.setText("GENERIC RED FRAGMENT - UID $myIndex")
            chosenColorTV?.setBackgroundColor(Color.rgb(255, 150, 150))
        } else if (choiceId == 1) {
            chosenColorTV?.setText("GENERIC BLUE FRAGMENT - UID $myIndex")
            chosenColorTV?.setBackgroundColor(Color.rgb(150,150,255))
        }
    }

    companion object {
        private var fragmentCount: Int = 0

        @JvmStatic
        fun newInstance(choice: Int) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putInt("COLOR_CHOICE", choice)
                }
            }

    }
}