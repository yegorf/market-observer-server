package com.parsing.marketobserverserver.rest.controller

import com.parsing.marketobserverserver.database.entity.UserEntity
import com.parsing.marketobserverserver.database.repository.UserRepository
import com.parsing.marketobserverserver.rest.dto.request.UserDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userRepository: UserRepository) {

    @GetMapping
    fun getUser() = "user"

    @PostMapping("/login")
    fun login(@RequestBody userDto: UserDto): Int {
        val dbUser = userRepository.findByEmail(userDto.email)
        return if (dbUser.email == userDto.email && dbUser.password == userDto.password) {
            200
        } else {
            300
        }
    }

    @PostMapping("/registerUser")
    fun registerUser(@RequestBody userDto: UserDto): Int {
        userRepository.save(UserEntity.fromDto(userDto))
        return 200
    }
}