package com.kshired.spring.study.domain.post.repository

import com.kshired.spring.study.domain.post.Post

interface PostRepository {
    fun save(post: Post): Long

    fun findByIdOrNull(id: Long): Post?

    fun findAll(): List<Post>
}
