package com.parsing.marketobserverserver.database.entity

import javax.persistence.*

@Entity
@Table(name = "query")
data class Query(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "creation_time")
        var creationTime: String,

        @ManyToOne
        var user: User
)