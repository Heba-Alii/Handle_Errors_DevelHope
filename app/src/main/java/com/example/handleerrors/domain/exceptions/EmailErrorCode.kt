package com.example.handleerrors.domain.exceptions

enum class EmailErrorCode(val code: Int) {
    NotFound(404),
    RequestTimeOut(408),
    ERROR(0)
}