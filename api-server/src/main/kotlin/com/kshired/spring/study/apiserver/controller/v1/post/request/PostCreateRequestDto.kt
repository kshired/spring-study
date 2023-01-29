package com.kshired.spring.study.apiserver.controller.v1.post.request

import com.kshired.spring.study.domain.post.command.PostCreateCommand

data class PostCreateRequestDto(
    val memberId: Long,
    val title: String,
    val content: String,
) {
    fun toCreateCommand(): PostCreateCommand {
        return PostCreateCommand(
            memberId = memberId,
            title = title,
            content = content
        )
    }
}
