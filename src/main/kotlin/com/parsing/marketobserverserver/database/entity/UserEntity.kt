package com.parsing.marketobserverserver.database.entity

import com.parsing.marketobserverserver.rest.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "user")
data class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = -1,

        @Column(name = "email")
        var email: String = "",

        @Column(name = "password")
        var password: String = ""
) {
    companion object {
        fun fromDto(userDto: UserDto): UserEntity {
            val userEntity = UserEntity()
            userEntity.email = userDto.email
            userEntity.password = userDto.password
            return userEntity
        }
    }
}
