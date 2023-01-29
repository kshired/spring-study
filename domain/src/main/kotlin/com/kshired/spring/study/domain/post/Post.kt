package com.kshired.spring.study.domain.post

import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.domain.post.command.PostCreateCommand

data class Post(
    val id: Long,
    val title: String,
    val content: String,
    val member: Member
) {
    companion object {
        fun fromCreateCommand(createCommand: PostCreateCommand, member: Member): Post {
            return Post(
                0,
                title = createCommand.title,
                content = createCommand.content,
                member = member
            )
        }
    }
}
