package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.Query
import com.parsing.marketobserverserver.database.repository.QueryRepository
import com.parsing.marketobserverserver.database.repository.UserRepository
import com.parsing.marketobserverserver.rest.dto.QueryDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/query")
class QueryController(val queryRepository: QueryRepository, val userRepository: UserRepository) {

    @GetMapping("/userQueries")
    fun getUserQueries(email: String): List<Query> {
        return queryRepository.findAllByUser(userRepository.findByEmail(email))
    }

    @PostMapping("/addQuery")
    fun addQuery(@RequestBody queryDto: QueryDto) {
        val query = Query(11, queryDto.value, System.currentTimeMillis(), userRepository.findByEmail(queryDto.email))
        queryRepository.save(query)
    }

    @PostMapping("/deleteQuery")
    fun deleteQuery() {

    }
}