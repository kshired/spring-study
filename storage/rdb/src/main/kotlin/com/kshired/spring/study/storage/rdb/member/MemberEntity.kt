package com.kshired.spring.study.storage.rdb.member

import com.kshired.spring.study.domain.member.Member
import com.kshired.spring.study.storage.rdb.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "member")
internal class MemberEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    val id: Long,

    @Column(name = "email")
    val email: String,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "password")
    var password: String,
) : BaseEntity() {
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
            id = id,
            email = email,
            nickname = nickname,
            password = password
        )
    }
}
