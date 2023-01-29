package com.kshired.spring.study.apiserver.controller.v1.member.request

import com.kshired.spring.study.domain.member.command.MemberCreateCommand

data class MemberCreateRequestDto(
    val email: String,
    val nickname: String,
    val password: String
) {
    fun toCreateCommand(): MemberCreateCommand {
        return MemberCreateCommand(email, nickname, password)
    }
}
