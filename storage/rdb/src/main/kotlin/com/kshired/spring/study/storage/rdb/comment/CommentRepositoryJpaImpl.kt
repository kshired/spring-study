package com.kshired.spring.study.storage.rdb.comment

import com.kshired.spring.study.domain.comment.Comment
import com.kshired.spring.study.domain.comment.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class CommentRepositoryJpaImpl(
    private val commentJpaRepository: CommentJpaRepository
) : CommentRepository{
    override fun save(comment: Comment): Long {
        return commentJpaRepository.save(CommentEntity.fromDomain(comment)).id
    }

    override fun findByIdOrNull(id: Long): Comment? {
        return commentJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun update(comment: Comment) {
        val commentEntity = commentJpaRepository.findByIdOrNull(comment.id)
        commentEntity?.updateFromDomain(comment)
    }
}
