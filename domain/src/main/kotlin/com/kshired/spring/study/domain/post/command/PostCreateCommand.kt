package com.kshired.spring.study.domain.post.command

data class PostCreateCommand(
    val memberId: Long,
    val title: String,
    val content: String
)
