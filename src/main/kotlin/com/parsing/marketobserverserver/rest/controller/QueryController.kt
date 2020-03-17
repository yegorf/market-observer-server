package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.Query
import com.parsing.marketobserverserver.database.repository.QueryRepository
import com.parsing.marketobserverserver.database.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/query")
class QueryController(val queryRepository: QueryRepository, val userRepository: UserRepository) {

    @GetMapping
    fun getUserQueries(email: String): List<Query> {
        return queryRepository.findAllByUser(userRepository.findByEmail(email))
    }
}