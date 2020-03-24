package com.parsing.marketobserverserver.database.repository

import com.parsing.marketobserverserver.database.entity.LinkEntity
import com.parsing.marketobserverserver.database.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QueryRepository : CrudRepository<LinkEntity, Long> {

    fun findAllByUser(user: UserEntity): List<LinkEntity>
}
