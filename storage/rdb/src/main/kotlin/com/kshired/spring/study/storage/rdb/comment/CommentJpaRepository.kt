package com.kshired.spring.study.storage.rdb.comment

import org.springframework.data.jpa.repository.JpaRepository

internal interface CommentJpaRepository : JpaRepository<CommentEntity, Long>
