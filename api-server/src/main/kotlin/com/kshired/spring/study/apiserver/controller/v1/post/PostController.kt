package com.kshired.spring.study.apiserver.controller.v1.post

import com.kshired.spring.study.apiserver.controller.v1.post.request.PostCreateRequestDto
import com.kshired.spring.study.apiserver.controller.v1.post.response.PostResponseDto
import com.kshired.spring.study.common.util.response.ApiResponse
import com.kshired.spring.study.domain.post.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/posts")
class PostController(
    private val postService: PostService
) {
    @GetMapping("/{id}")
    fun findById(
        @PathVariable("id") id: Long
    ): ApiResponse<PostResponseDto> {
        val post = postService.findById(id)
        return ApiResponse.success(PostResponseDto.from(post))
    }

    @GetMapping
    fun findAll(): ApiResponse<List<PostResponseDto>> {
        val posts = postService.findAll()
        return ApiResponse.success(posts.map { PostResponseDto.from(it) })
    }

    @PostMapping
    fun createPost(
        @RequestBody postCreateRequestDto: PostCreateRequestDto
    ): ApiResponse<Long> {
        val id = postService.save(postCreateRequestDto.toCreateCommand())
        return ApiResponse.success(id)
    }
}
