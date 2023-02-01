package com.kshired.spring.study.apiserver.controller.v1.comment

import com.kshired.spring.study.apiserver.controller.v1.comment.request.CommentCreateRequestDto
import com.kshired.spring.study.apiserver.controller.v1.comment.request.CommentUpdateRequestDto
import com.kshired.spring.study.apiserver.controller.v1.comment.response.CommentResponseDto
import com.kshired.spring.study.common.util.response.ApiResponse
import com.kshired.spring.study.domain.comment.service.CommentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/comments")
class CommentController(
    private val commentService: CommentService
) {
    @GetMapping("/{id}")
    fun findById(
        @PathVariable("id") id: Long
    ): ApiResponse<CommentResponseDto> {
        val comment = commentService.findById(id)
        return ApiResponse.success(CommentResponseDto.from(comment))
    }

    @PostMapping
    fun createComment(
        @RequestBody commentCreateRequestDto: CommentCreateRequestDto
    ): ApiResponse<Long> {
        val id = commentService.save(commentCreateRequestDto.toCreateCommand())
        return ApiResponse.success(id)
    }

    @PutMapping("/{id}")
    fun updateComment(
        @PathVariable("id") id: Long,
        @RequestBody commentUpdateRequestDto: CommentUpdateRequestDto
    ): ApiResponse<Unit> {
        commentService.update(commentUpdateRequestDto.toUpdateCommand(id))
        return ApiResponse.success(Unit)
    }
}
