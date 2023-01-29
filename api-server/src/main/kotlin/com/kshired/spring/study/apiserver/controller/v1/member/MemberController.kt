package com.kshired.spring.study.apiserver.controller.v1.member

import com.kshired.spring.study.apiserver.controller.v1.member.request.MemberCreateRequestDto
import com.kshired.spring.study.apiserver.controller.v1.member.request.MemberUpdateRequestDto
import com.kshired.spring.study.apiserver.controller.v1.member.response.MemberResponseDto
import com.kshired.spring.study.common.util.response.ApiResponse
import com.kshired.spring.study.domain.member.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/members")
class MemberController(
    private val memberService: MemberService
) {
    @GetMapping("/{id}")
    fun findById(
        @PathVariable("id") id: Long
    ): ApiResponse<MemberResponseDto> {
        val member = memberService.findById(id)
        return ApiResponse.success(MemberResponseDto.from(member))
    }

    @PostMapping
    fun createMember(
        @RequestBody memberCreateRequestDto: MemberCreateRequestDto
    ): ApiResponse<Long> {
        val id = memberService.save(memberCreateRequestDto.toCreateCommand())
        return ApiResponse.success(id)
    }

    @PutMapping("/{id}")
    fun updateMember(
        @PathVariable("id") id: Long,
        @RequestBody memberUpdateRequestDto: MemberUpdateRequestDto
    ): ApiResponse<Unit> {
        memberService.update(memberUpdateRequestDto.toUpdateCommand(id))
        return ApiResponse.success(Unit)
    }
}
