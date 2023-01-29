package com.kshired.spring.study.storage.rdb.member

import org.springframework.data.jpa.repository.JpaRepository

internal interface MemberJpaRepository : JpaRepository<MemberEntity, Long>
