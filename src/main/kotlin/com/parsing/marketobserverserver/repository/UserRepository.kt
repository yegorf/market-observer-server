package com.parsing.marketobserverserver.repository

import com.parsing.marketobserverserver.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {

}