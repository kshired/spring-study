package com.kshired.spring.study.domain.post.service

import com.kshired.spring.study.common.error.BadRequestException
import com.kshired.spring.study.domain.member.repository.MemberRepository
import com.kshired.spring.study.domain.post.Post
import com.kshired.spring.study.domain.post.command.PostCreateCommand
import com.kshired.spring.study.domain.post.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PostService(
    private val postRepository: PostRepository,
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun save(postCreateCommand: PostCreateCommand): Long {
        val member = memberRepository.findByIdOrNull(postCreateCommand.memberId)
            ?: throw BadRequestException("${postCreateCommand.memberId}번의 멤버를 찾을 수 없습니다.")

        return postRepository.save(Post.fromCreateCommand(postCreateCommand, member))
    }

    fun findById(id: Long): Post {
        return postRepository.findByIdOrNull(id)
            ?: throw BadRequestException("${id}번의 게시글을 찾을 수 없습니다.")
    }

    fun findAll(): List<Post> {
        return postRepository.findAll()
    }
}
