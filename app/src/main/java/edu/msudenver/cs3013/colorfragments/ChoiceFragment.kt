package edu.msudenver.cs3013.colorfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [ChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoiceFragment : Fragment() {

    private lateinit var choiceListener: ChoiceListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val redT = view.findViewById<TextView>(R.id.redText)
        val blueT = view.findViewById<TextView>(R.id.blueText)

        blueT.setOnClickListener {
            var choice : Int = 1
            Log.d("ChoiceFragment", "blueT clicked. Choice: $choice")
            choiceListener.onSelected(choice)
        }
        redT.setOnClickListener {
            var choice : Int = 2
            Log.d("ChoiceFragment", "redT clicked. Choice: $choice")
            choiceListener.onSelected(choice)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        } else {
            throw RuntimeException("Must implement ChoiceListener")
        }
    }

}