package com.parsing.marketobserverserver.rest.dto.response

import com.parsing.marketobserverserver.database.entity.ResultEntity

data class ResultDto(
    var title: String,
    var url: String,
    var imageUrl: String
) {
    companion object {
        fun fromEntity(advertEntity: ResultEntity): ResultDto {
            return ResultDto(advertEntity.title, advertEntity.url, advertEntity.imageUrl)
        }
    }
}