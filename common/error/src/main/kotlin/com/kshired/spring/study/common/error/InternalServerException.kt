package com.kshired.spring.study.common.error

class InternalServerException(
    override val message: String
) : Exception(message)
