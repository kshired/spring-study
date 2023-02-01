package com.kshired.spring.study.domain.comment

import com.kshired.spring.study.domain.comment.command.CommentCreateCommand
import com.kshired.spring.study.domain.comment.command.CommentUpdateCommand
import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.domain.post.Post

data class Comment(
    val id: Long,
    val member: Member,
    val post: Post,
    var content: String
) {
    fun update(updateCommand: CommentUpdateCommand) {
        content = updateCommand.content
    }

    companion object {
        fun fromCreateCommand(createCommand: CommentCreateCommand, member: Member, post: Post): Comment {
            return Comment(
                0,
                member = member,
                post = post,
                content = createCommand.content,
            )
        }
    }
}
