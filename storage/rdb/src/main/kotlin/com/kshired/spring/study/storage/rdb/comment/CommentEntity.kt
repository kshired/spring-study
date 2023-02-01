package com.kshired.spring.study.storage.rdb.comment

import com.kshired.spring.study.domain.comment.Comment
import com.kshired.spring.study.storage.rdb.BaseEntity
import com.kshired.spring.study.storage.rdb.member.MemberEntity
import com.kshired.spring.study.storage.rdb.post.PostEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "comments")
internal class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    var id: Long = 0,

    @Column(name = "content")
    val content: String,

    @ManyToOne
    @JoinColumn(name = "member_id")
    val member: MemberEntity,

    @ManyToOne
    @JoinColumn(name = "post_id")
    val post: PostEntity
) : BaseEntity() {
    companion object {
        fun fromDomain(comment: Comment): CommentEntity {
            return CommentEntity(
                id = comment.id,
                content = comment.content,
                member = MemberEntity.fromDomain(comment.member),
                post = PostEntity.fromDomain(comment.post)
            )
        }
    }

    fun toDomain(): Comment {
        return Comment(
            id = id,
            content = content,
            member = member.toDomain(),
            post = post.toDomain()
        )
    }

    fun updateFromDomain(comment: Comment) {
        comment.content = content
    }
}
