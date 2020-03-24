package com.parsing.marketobserverserver.rest.dto.response

data class LinkDto(
        var value: String,
        var results: List<ResultDto>
)