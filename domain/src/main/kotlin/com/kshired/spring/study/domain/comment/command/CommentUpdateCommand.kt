package com.kshired.spring.study.domain.comment.command

data class CommentUpdateCommand(
    val id: Long,
    val postId: Long,
    val memberId: Long,
    val content: String
)
