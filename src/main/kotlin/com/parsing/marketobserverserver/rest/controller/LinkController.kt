package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.LinkEntity
import com.parsing.marketobserverserver.database.repository.AdvertRepository
import com.parsing.marketobserverserver.database.repository.QueryRepository
import com.parsing.marketobserverserver.database.repository.UserRepository
import com.parsing.marketobserverserver.rest.dto.request.AddLinkDto
import com.parsing.marketobserverserver.rest.dto.response.ResultDto
import com.parsing.marketobserverserver.rest.dto.response.LinkDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/link")
class LinkController(val queryRepository: QueryRepository,
                     val userRepository: UserRepository,
                     val advertRepository: AdvertRepository) {

    @GetMapping("/userLinks")
    fun getUserQueries(email: String): List<LinkDto> {
        val queryEntities = queryRepository.findAllByUser(userRepository.findByEmail(email))
        val queries = mutableListOf<LinkDto>()

        queryEntities.forEach {
            val advertEntities = advertRepository.findAllByQuery(it)
            val results = mutableListOf<ResultDto>()

            advertEntities.forEach { advert ->
                results.add(ResultDto.fromEntity(advert))
            }
            queries.add(LinkDto(it.value, results))
        }

        return queries
    }

    @PostMapping("/addLink")
    fun addQuery(@RequestBody queryDto: AddLinkDto) {
        val query = LinkEntity(11, queryDto.value, "mock", userRepository.findByEmail(queryDto.email))
        queryRepository.save(query)
    }

    @PostMapping("/deleteLink")
    fun deleteQuery() {

    }
}