package com.parsing.marketobserverserver.database.repository

import com.parsing.marketobserverserver.database.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {

    fun findByEmail(email: String): User
}