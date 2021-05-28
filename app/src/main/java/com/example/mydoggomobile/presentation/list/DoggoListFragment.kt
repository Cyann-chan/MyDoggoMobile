package com.example.mydoggomobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mydoggomobile.R
import com.example.mydoggomobile.presentation.list.api.DoggoApi
import com.example.mydoggomobile.presentation.list.api.DoggoListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DoggoListFragment : Fragment() {

    private lateinit var recyclerView : RecyclerView

    private val adapter = DoggoAdapter(listOf(), ::onClickedDoggo)

    private val viewModel: DoggoListViewModel by viewModels()

    private lateinit var loader : ProgressBar
    private lateinit var texterror : TextView



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_doggo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =  view.findViewById(R.id.dog_recyclerview)
        loader = view.findViewById(R.id.loader)
        texterror = view.findViewById(R.id.texterror)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DoggoListFragment.adapter
        }


        viewModel.doggoList.observe(viewLifecycleOwner, Observer {dogModel ->
            loader.isVisible = dogModel is DogLoader
            texterror.isVisible = dogModel is DogFailure

            if (dogModel is DogSuccess)
                adapter.updateList(dogModel.doggolist)
        })


      // val doggoList = arrayListOf<Doggo>().apply {
      //     add(Doggo("Golden Retriever"))
      //     add(Doggo("Yuski"))
      //     add(Doggo("Chihuahua"))
      //     add(Doggo("Berger Allemand"))
      // }

    }

    private fun onClickedDoggo(doggo: DoggoListResponse) {
        findNavController().navigate(R.id.navigateToDoggoDetailFragment, bundleOf(
                "DoggoArg" to doggo.name
        ))
    }
}