package com.kshired.spring.study.domain.comment.command

data class CommentCreateCommand(
    val postId: Long,
    val memberId: Long,
    val content: String
)
