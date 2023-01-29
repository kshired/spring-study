package com.kshired.spring.study.domain.member.command

data class MemberUpdateCommand(
    val id: Long,
    val nickname: String?,
    val originalPassword: String?,
    val password: String?
)
