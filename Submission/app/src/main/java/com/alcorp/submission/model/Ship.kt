package com.alcorp.submission.model

data class Ship(
    val id: Int,
    val shipName: String,
    val shipClass: String,
    val shipCountry: String,
    val shipDesc: String,
    val shipPhoto: Int
)
