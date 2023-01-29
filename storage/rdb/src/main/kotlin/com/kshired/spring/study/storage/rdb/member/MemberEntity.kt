package com.kshired.spring.study.storage.rdb.member

import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.storage.rdb.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "member")
internal class MemberEntity(
    id: Long = 0,

    @Column(name = "email")
    val email: String,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "password")
    var password: String,
) : BaseEntity(id = id) {
    companion object {
        fun fromDomain(member: Member): MemberEntity {
            return MemberEntity(
                id = member.id,
                email = member.email,
                nickname = member.nickname,
                password = member.password
            )
        }
    }

    fun updateFromDomain(member: Member) {
        password = member.password
        nickname = member.nickname
    }

    fun toDomain(): Member {
        return Member(
            id = id!!,
            email = email,
            nickname = nickname,
            password = password
        )
    }
}
