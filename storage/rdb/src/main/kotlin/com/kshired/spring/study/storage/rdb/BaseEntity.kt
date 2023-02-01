package com.kshired.spring.study.storage.rdb

import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime

@MappedSuperclass
internal abstract class BaseEntity(
    @CreationTimestamp
    val createdAt: ZonedDateTime? = null,

    @UpdateTimestamp
    val updatedAt: ZonedDateTime? = null
)
