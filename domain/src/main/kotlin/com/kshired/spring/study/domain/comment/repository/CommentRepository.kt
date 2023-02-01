package com.kshired.spring.study.domain.comment.repository

import com.kshired.spring.study.domain.comment.Comment

interface CommentRepository {
    fun save(comment: Comment): Long

    fun findByIdOrNull(id: Long): Comment?

    fun update(comment: Comment)
}
