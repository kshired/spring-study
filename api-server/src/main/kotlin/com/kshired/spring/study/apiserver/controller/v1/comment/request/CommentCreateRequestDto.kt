package com.kshired.spring.study.apiserver.controller.v1.comment.request

import com.kshired.spring.study.domain.comment.command.CommentCreateCommand

data class CommentCreateRequestDto(
    val content: String,
    val memberId: Long,
    val postId: Long
) {
    fun toCreateCommand(): CommentCreateCommand {
        return CommentCreateCommand(
            postId = postId,
            memberId = memberId,
            content = content
        )
    }
}
