package com.example.mydoggomobile.presentation.list.api

data class DoggoListResponse(
    val name: String,
    val temperament : String,
    val life_span: String,
    val origin: String,
    val image : Image
)

