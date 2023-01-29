package com.kshired.spring.study.domain.member

import com.kshired.spring.study.domain.post.Post

data class MemberLike(
    val id: Long,
    val member: Member,
    val post: Post
)
