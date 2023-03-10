package com.kshired.spring.study.apiserver.support.response

data class CursorPageResponse<T>(
    val offset: Long,
    val content: List<T>,
    val totalElements: Long,
    val hasNext: Boolean,
    val contentSize: Int
)