package com.kshired.spring.study.storage.rdb.post

import org.springframework.data.jpa.repository.JpaRepository

internal interface PostJpaRepository : JpaRepository<PostEntity, Long>
