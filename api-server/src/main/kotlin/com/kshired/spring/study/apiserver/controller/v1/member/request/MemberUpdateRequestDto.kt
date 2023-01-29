package com.kshired.spring.study.apiserver.controller.v1.member.request

import com.kshired.spring.study.domain.member.command.MemberUpdateCommand

data class MemberUpdateRequestDto(
    val nickname: String?,
    val originalPassword: String?,
    val password: String?
) {
    fun toUpdateCommand(id: Long): MemberUpdateCommand {
        return MemberUpdateCommand(id, nickname, originalPassword, password)
    }
}
