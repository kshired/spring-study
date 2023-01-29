package com.kshired.spring.study.domain.member.repository

import com.kshired.spring.study.domain.member.Member

interface MemberRepository {
    fun save(member: Member): Long

    fun update(member: Member)

    fun findByIdOrNull(id: Long): Member?
}
