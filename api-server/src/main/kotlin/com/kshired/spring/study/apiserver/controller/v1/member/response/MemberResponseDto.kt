package com.kshired.spring.study.apiserver.controller.v1.member.response

import com.kshired.spring.study.domain.member.Member

data class MemberResponseDto(
    val id: Long,
    val email: String,
    val nickname: String
) {
    companion object {
        fun from(member: Member): MemberResponseDto {
            return MemberResponseDto(member.id, member.email, member.nickname)
        }
    }
}
