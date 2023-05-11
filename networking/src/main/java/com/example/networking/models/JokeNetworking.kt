package com.example.networking.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JokeNetworking(
    @SerialName("id") val id: Int,
    @SerialName("type") val type: String,
    @SerialName("setup") val question: String,
    @SerialName("punchline") val punchline: String,
)
