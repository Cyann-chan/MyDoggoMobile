package com.example.mydoggomobile.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydoggomobile.presentation.list.api.DoggoListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoggoListViewModel : ViewModel(){

    val doggoList: MutableLiveData<List<DoggoListResponse>> = MutableLiveData()

    init {
        callApi()
    }



    private fun callApi() {
        Singleton.doggoApi.getDoggoList().enqueue(object : Callback<List<DoggoListResponse>> {
            override fun onFailure(call: Call<List<DoggoListResponse>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<DoggoListResponse>>, response: Response<List<DoggoListResponse>>) {
                if(response.isSuccessful && response.body() != null){
                    val doggoResponse : List<DoggoListResponse> = response.body()!!
                    doggoList.value = doggoResponse
                }
            }
        })
    }
}