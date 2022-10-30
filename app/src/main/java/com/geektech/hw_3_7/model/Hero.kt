package com.geektech.hw_3_7.model

import java.io.Serializable

data class Hero(
    val name: String? = null,
    val status: String? = null,
    val image: String? = null
): Serializable

