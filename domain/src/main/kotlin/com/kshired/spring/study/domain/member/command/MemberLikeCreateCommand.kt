package com.kshired.spring.study.domain.member.command
data class MemberLikeCreateCommand(
    val memberId: Long,
    val postId: Long
)
