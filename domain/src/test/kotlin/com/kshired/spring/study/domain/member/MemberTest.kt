package com.kshired.spring.study.domain.member

import com.kshired.spring.study.common.error.BadRequestException
import com.kshired.spring.study.domain.member.command.MemberCreateCommand
import com.kshired.spring.study.domain.member.command.MemberUpdateCommand
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MemberTest : StringSpec({
    "멤버 생성 요청에 의해 멤버가 생성된다." {
        // given
        val memberCreateCommand = MemberCreateCommand("shiroed1211@gmail.com", "kshired", "password")

        // when
        val member = Member.from(memberCreateCommand)

        // then
        member.email shouldBe "shiroed1211@gmail.com"
        member.nickname shouldBe "kshired"
        member.password shouldBe "password"
    }

    "멤버 닉네임 변경 요청에 의해 닉네임이 변경된다." {
        // given
        val member = Member(1, "shiroed1211@gmail.com", "kshired", "password")
        val memberUpdateCommand = MemberUpdateCommand(1, "test", null, null)

        // when
        member.update(memberUpdateCommand)

        // then
        member.nickname shouldBe "test"
    }

    "멤버 비밀번호 변경 요청에 의해 비밀번호가 변경된다." {
        // given
        val member = Member(1, "shiroed1211@gmail.com", "kshired", "password")
        val memberUpdateCommand = MemberUpdateCommand(1, null,"password", "test")

        // when
        member.update(memberUpdateCommand)

        // then
        member.password shouldBe "test"
    }

    "멤버 닉네임, 비밀번호 변경 요청에 의해 닉네임과 비밀번호 모두 변경된다." {
        // given
        val member = Member(1, "shiroed1211@gmail.com", "kshired", "password")
        val memberUpdateCommand = MemberUpdateCommand(1, "test", "password", "test")

        // when
        member.update(memberUpdateCommand)

        // then
        member.nickname shouldBe "test"
        member.password shouldBe "test"
    }

    "멤버 비밀번호 변경 요청시, 원래 비밀번호가 일치하지 않으면 비밀번호가 변경되지 않는다." {
        // given
        val member = Member(1, "shiroed1211@gmail.com", "kshired", "password")
        val memberUpdateCommand = MemberUpdateCommand(1, null, "password1", "test")

        // when
        val exception = shouldThrow<BadRequestException> {
            member.update(memberUpdateCommand)
        }

        // then
        member.password shouldBe "password"
        exception.message shouldBe "이전 비밀번호가 일치하지 않습니다."
    }

    "멤버 닉네임, 비밀번호 변경 요청시, 원래 비밀번호가 일치하지 않으면 모두 변경되지 않는다." {
        // given
        val member = Member(1, "shiroed1211@gmail.com", "kshired", "password")
        val memberUpdateCommand = MemberUpdateCommand(1, "test", "password1", "test")

        // when
        val exception = shouldThrow<BadRequestException> {
            member.update(memberUpdateCommand)
        }

        // then
        member.nickname shouldBe "kshired"
        member.password shouldBe "password"
        exception.message shouldBe "이전 비밀번호가 일치하지 않습니다."
    }
})
