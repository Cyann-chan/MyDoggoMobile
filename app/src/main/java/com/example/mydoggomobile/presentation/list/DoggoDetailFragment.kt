package com.example.mydoggomobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.mydoggomobile.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */




class DoggoDetailFragment : Fragment() {

    private lateinit var textView : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_doggo, container, false)
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var doggoName = arguments?.getString("DoggoArg")?: "Akita"
        view.findViewById<Button>(R.id.button_third).setOnClickListener {
            findNavController().navigate(R.id.returnToDoggoListFragment)
        }

        textView = view.findViewById(R.id.doggo_detail)

        textView.text = doggoName
    }
}