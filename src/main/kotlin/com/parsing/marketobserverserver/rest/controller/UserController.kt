package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.User
import com.parsing.marketobserverserver.database.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getUser() = "user"

    @PostMapping("/login")
    fun login(@RequestBody user: User): Int {
        val dbUser = userRepository.findByEmail(user.email)
        return if (dbUser.email == user.email && dbUser.password == user.password) {
            200
        } else {
            300
        }
    }

    @PostMapping("/registerUser")
    fun registerUser(@RequestBody user: User): Int {
        userRepository.save(user)
        return 200
    }
}