package com.example.mydoggomobile.presentation.list

import com.example.mydoggomobile.presentation.list.api.DoggoListResponse

sealed class DoggoModel {


}

data class  DogSuccess(val doggolist : List<DoggoListResponse>) : DoggoModel()
object  DogFailure: DoggoModel()
object  DogLoader: DoggoModel()