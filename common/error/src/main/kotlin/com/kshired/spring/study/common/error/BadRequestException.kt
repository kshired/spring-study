package com.kshired.spring.study.common.error

data class BadRequestException(
    override val message: String
) : Exception(message)
