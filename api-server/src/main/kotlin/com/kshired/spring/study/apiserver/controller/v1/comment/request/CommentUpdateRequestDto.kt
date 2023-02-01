package com.kshired.spring.study.apiserver.controller.v1.comment.request

import com.kshired.spring.study.domain.comment.command.CommentUpdateCommand

data class CommentUpdateRequestDto(
    val id: Long,
    val content: String,
    val memberId: Long,
    val postId: Long
) {
    fun toUpdateCommand(id: Long): CommentUpdateCommand {
        return CommentUpdateCommand(
            id = id,
            postId = postId,
            memberId = memberId,
            content = content
        )
    }
}
