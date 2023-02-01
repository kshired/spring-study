package com.kshired.spring.study.domain.comment.service

import com.kshired.spring.study.common.error.BadRequestException
import com.kshired.spring.study.domain.comment.Comment
import com.kshired.spring.study.domain.comment.command.CommentCreateCommand
import com.kshired.spring.study.domain.comment.command.CommentUpdateCommand
import com.kshired.spring.study.domain.comment.repository.CommentRepository
import com.kshired.spring.study.domain.member.repository.MemberRepository
import com.kshired.spring.study.domain.post.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CommentService(
    private val commentRepository: CommentRepository,
    private val postRepository: PostRepository,
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun save(commentCreateCommand: CommentCreateCommand): Long {
        val post = postRepository.findByIdOrNull(commentCreateCommand.postId)
            ?: throw BadRequestException("${commentCreateCommand.postId}번의 게시글을 찾을 수 없습니다.")
        val member = memberRepository.findByIdOrNull(commentCreateCommand.memberId)
            ?: throw BadRequestException("${commentCreateCommand.memberId}번의 멤버를 찾을 수 없습니다.")

        return commentRepository.save(Comment.fromCreateCommand(commentCreateCommand, member, post))
    }

    fun findById(id: Long): Comment {
        return commentRepository.findByIdOrNull(id)
            ?: throw BadRequestException("${id}번의 댓글을 찾을 수 없습니다.")
    }

    @Transactional
    fun update(updateCommand: CommentUpdateCommand) {
        val comment = findById(updateCommand.id)
        if (comment.member.id != updateCommand.memberId || comment.post.id != updateCommand.postId) {
            throw BadRequestException("${updateCommand.id}번의 댓글은 해당 유저 혹은 게시글의 댓글이 아닙니다.")
        }

        comment.update(updateCommand)
        commentRepository.update(comment)
    }
}
