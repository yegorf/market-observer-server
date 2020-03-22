package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.Advert
import com.parsing.marketobserverserver.database.repository.AdvertRepository
import com.parsing.marketobserverserver.database.repository.QueryRepository
import com.parsing.marketobserverserver.database.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/advert")
class AdvertController(val advertRepository: AdvertRepository,
                       val queryRepository: QueryRepository,
                       val userRepository: UserRepository) {

    @GetMapping("/userResults")
    fun getUserResults(email: String): List<Advert> {
        val user = userRepository.findByEmail(email)
        val queries = queryRepository.findAllByUser(user)
        val adverts = mutableListOf<Advert>()
        queries.forEach {
            adverts.addAll(advertRepository.findAllByQuery(it))
        }
        return adverts
    }
}