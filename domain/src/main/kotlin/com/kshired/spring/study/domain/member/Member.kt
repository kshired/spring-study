package com.kshired.spring.study.domain.member

import com.kshired.spring.study.domain.member.command.MemberCreateCommand
import com.kshired.spring.study.domain.member.command.MemberUpdateCommand

data class Member(
    val id: Long,
    val email: String,
    var nickname: String,
    var password: String
) {
    companion object {
        fun from(memberCreateRequest: MemberCreateCommand) : Member {
            return Member(
                id = 0,
                email = memberCreateRequest.email,
                nickname = memberCreateRequest.nickname,
                password = memberCreateRequest.password
            )
        }
    }

    fun update(memberUpdateCommand: MemberUpdateCommand) {
        memberUpdateCommand.password?.let {
            password = it
        }

        memberUpdateCommand.nickname?.let {
            nickname = it
        }
    }
}
