package com.example.mydoggomobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.mydoggomobile.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */




class DoggoDetailFragment : Fragment() {

    private lateinit var textView : TextView
    private lateinit var image: ImageView

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
        var doggoTemp = arguments?.getString("DoggoTemp")?: "Nice"
        var doggoImg = arguments?.getString("url")?: "https://images.dog.ceo/breeds/affenpinscher/n02110627_2748.jpg"
        var doggoLife = arguments?.getString("DoggoLife")?: "10 years"
        var doggoOrigin = arguments?.getString("DoggoOrigin")?: "Origin unlisted"

        view.findViewById<Button>(R.id.button_third).setOnClickListener {
            findNavController().navigate(R.id.returnToDoggoListFragment)
        }

        textView = view.findViewById(R.id.doggo_detail)
        textView.text = doggoName

        textView = view.findViewById(R.id.doggo_life_span)
        textView.text = doggoLife

        textView = view.findViewById(R.id.doggo_temperament)
        textView.text = doggoTemp

        textView = view.findViewById(R.id.doggo_origin)
        textView.text = doggoOrigin

        image = view.findViewById(R.id.doggo_detail_image)
        Glide.with(this)
            .load(doggoImg)
            .centerCrop()
            .into(image)
    }
}