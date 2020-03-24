package com.parsing.marketobserverserver.database.entity

import javax.persistence.*

@Entity
@Table(name = "result")
data class ResultEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(name = "title")
        var title: String,

        @Column(name = "url")
        var url: String,

        @Column(name = "image_url")
        var imageUrl: String,

        @ManyToOne
        var query: LinkEntity
)