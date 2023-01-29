package com.kshired.spring.study.apiserver.controller.v1.post.response

import com.kshired.spring.study.domain.post.Post

data class PostResponseDto(
    val id: Long,
    val title: String,
    val content: String,
    val author: String
) {
    companion object {
        fun from(post: Post): PostResponseDto {
            return PostResponseDto(post.id, post.title, post.content, post.member.nickname)
        }
    }
}
