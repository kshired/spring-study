package com.kshired.spring.study.domain.member.service

import com.kshired.spring.study.common.error.BadRequestException
import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.domain.member.command.MemberCreateCommand
import com.kshired.spring.study.domain.member.command.MemberUpdateCommand
import com.kshired.spring.study.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class MemberService(
    private val memberRepository: MemberRepository
) {
    @Transactional
    fun save(memberCreateCommand: MemberCreateCommand): Long {
        val member = Member.from(memberCreateCommand)
        return memberRepository.save(member)
    }

    @Transactional
    fun update(memberUpdateCommand: MemberUpdateCommand) {
        val member = findById(memberUpdateCommand.id)
        member.update(memberUpdateCommand)
        memberRepository.update(member)
    }

    fun findById(id: Long): Member {
        return memberRepository.findByIdOrNull(id)
            ?: throw BadRequestException("${id}번의 멤버를 찾을 수 없습니다.")
    }
}
