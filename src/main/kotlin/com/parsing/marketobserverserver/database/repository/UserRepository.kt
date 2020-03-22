package com.parsing.marketobserverserver.database.repository

import com.parsing.marketobserverserver.database.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserEntity, Long> {

    fun findByEmail(email: String): UserEntity
}