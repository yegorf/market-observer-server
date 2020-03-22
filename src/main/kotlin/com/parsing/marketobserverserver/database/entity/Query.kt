package com.parsing.marketobserverserver.database.entity

import javax.persistence.*

@Entity
@Table(name = "query")
data class Query(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "value")
        var value: String,

        @Column(name = "timestamp")
        var timestamp: Long,

        @ManyToOne
        var user: UserEntity
)