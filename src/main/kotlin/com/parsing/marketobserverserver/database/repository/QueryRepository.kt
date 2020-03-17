package com.parsing.marketobserverserver.database.repository

import com.parsing.marketobserverserver.database.entity.Query
import com.parsing.marketobserverserver.database.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QueryRepository : CrudRepository<Query, Long> {

    fun findAllByUser(user: User): List<Query>
}