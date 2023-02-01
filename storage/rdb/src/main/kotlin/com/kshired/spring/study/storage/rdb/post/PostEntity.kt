package com.kshired.spring.study.storage.rdb.post

import com.kshired.spring.study.domain.post.Post
import com.kshired.spring.study.storage.rdb.BaseEntity
import com.kshired.spring.study.storage.rdb.member.MemberEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
internal class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    var id: Long = 0,

    @Column(name = "title")
    val title: String,

    @Column(name = "content")
    val content: String,

    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: MemberEntity
) : BaseEntity() {
    companion object {
        fun fromDomain(post: Post): PostEntity {
            return PostEntity(
                id = post.id,
                title = post.title,
                content = post.content,
                member = MemberEntity.fromDomain(post.member)
            )
        }
    }

    fun toDomain(): Post {
        return Post(
            id = id,
            title = title,
            content = content,
            member = member.toDomain()
        )
    }
}
