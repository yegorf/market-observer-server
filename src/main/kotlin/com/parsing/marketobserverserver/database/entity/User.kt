package com.parsing.marketobserverserver.database.entity

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "email")
        var email: String,

        @Column(name = "password")
        var password: String
)
