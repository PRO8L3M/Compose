package com.example.networking.mappers

import com.example.domain.mapper.Mapper
import com.example.domain.models.Joke
import com.example.networking.models.JokeNetworking
import javax.inject.Inject

class JokeNetworkingToDomainMapper @Inject constructor() : Mapper<JokeNetworking, Joke> {

    override fun map(source: JokeNetworking): Joke = Joke(
        id = source.id,
        type = source.type,
        question = source.question,
        punchline = source.punchline,
    )
}
