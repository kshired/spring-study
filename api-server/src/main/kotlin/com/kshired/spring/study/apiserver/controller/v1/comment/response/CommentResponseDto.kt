package com.kshired.spring.study.apiserver.controller.v1.comment.response

import com.kshired.spring.study.domain.comment.Comment

data class CommentResponseDto(
    val id: Long,
    val content: String,
    val postId: Long,
    val author: String
) {
    companion object {
        fun from(comment: Comment): CommentResponseDto {
            return CommentResponseDto(
                id = comment.id,
                content = comment.content,
                postId = comment.post.id,
                author = comment.member.nickname
            )
        }
    }
}
