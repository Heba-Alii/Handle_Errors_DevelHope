package com.example.handleerrors.domain.exceptions

import com.example.handleerrors.ui.util.ErrorMessage

sealed class EmailExceptions(private val errorCode: EmailErrorCode, message: String) :
    Exception(message) {
    fun mapException(emailExceptions: EmailExceptions) {
        when (emailExceptions.errorCode) {
            EmailErrorCode.NotFound -> ErrorMessage.NOT_FOUND
            EmailErrorCode.RequestTimeOut -> ErrorMessage.Request_Time_Out
            EmailErrorCode.ERROR -> ErrorMessage.ERROR
        }
    }
}

data class NotFoundException(val code: EmailErrorCode = EmailErrorCode.NotFound) :
    EmailExceptions(code, ErrorMessage.NOT_FOUND)

data class RequestTimeOut(val code: EmailErrorCode = EmailErrorCode.RequestTimeOut) :
    EmailExceptions(code, ErrorMessage.Request_Time_Out)

data class Error(val code: EmailErrorCode = EmailErrorCode.ERROR) :
    EmailExceptions(code, ErrorMessage.ERROR)