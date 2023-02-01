package com.kshired.spring.study.storage.rdb.member

import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.domain.member.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
internal class MemberRepositoryJpaImpl(
    private val memberJpaRepository: MemberJpaRepository
) : MemberRepository {
    override fun save(member: Member): Long {
        return memberJpaRepository.save(MemberEntity.fromDomain(member)).id
    }

    override fun update(member: Member) {
        val memberEntity = memberJpaRepository.findByIdOrNull(member.id)
        memberEntity?.updateFromDomain(member)
    }

    override fun findByIdOrNull(id: Long): Member? {
        val memberEntity = memberJpaRepository.findByIdOrNull(id)
        return memberEntity?.toDomain()
    }
}
