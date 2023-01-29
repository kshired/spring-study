package com.kshired.spring.study.storage.rdb.post

import com.kshired.spring.study.domain.post.Post
import com.kshired.spring.study.domain.post.repository.PostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class PostRepositoryJpaImpl(
    private val postJpaRepository: PostJpaRepository
) : PostRepository {
    override fun save(post: Post): Long {
        return postJpaRepository.save(PostEntity.fromDomain(post)).id!!
    }

    override fun findByIdOrNull(id: Long): Post? {
        return postJpaRepository.findByIdOrNull(id)?.toDomain()
    }

    override fun findAll(): List<Post> {
        return postJpaRepository.findAll().map { it.toDomain() }
    }
}
