package com.parsing.marketobserverserver.database.entity

import javax.persistence.*

@Entity
@Table(name = "link")
data class LinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "link")
        var value: String,

        @Column(name = "time")
        var time: String,

        @ManyToOne
        var user: UserEntity
)