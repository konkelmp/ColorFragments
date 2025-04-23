/**
 * Preston Konkel
 * ColorFragments Assignment
 * CS3013
 * Professor Elliot Evans
 */

package edu.msudenver.cs3013.colorfragments

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView

interface ChoiceListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), ChoiceListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (savedInstanceState == null) {
            val cfv = findViewById<FragmentContainerView>(R.id.upperfragment_container)
            val choiceFragment = ChoiceFragment()
            supportFragmentManager.beginTransaction().add(cfv.id, choiceFragment).commit()
        }
    }

    override fun onSelected(id: Int) {
        Log.d("MainActivity", "inside onSelected with id: $id")
        val fcv = findViewById<FragmentContainerView>(R.id.lowerfragment_container)
        val colorFragment = ColorFragment.newInstance(id)
        supportFragmentManager.beginTransaction().replace(fcv.id, colorFragment).addToBackStack(null).commit()
    }
}