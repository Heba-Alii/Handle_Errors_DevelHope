package com.example.handleerrors.domain.usecase

import com.example.handleerrors.data.repo.EmailRepoImpl
import com.example.handleerrors.domain.repo.EmailRepo
import com.example.handleerrors.ui.util.Response

class SubmitEmailUseCase(private val emailRepo: EmailRepo = EmailRepoImpl()) {
    suspend fun mailCondition(email: String): Response<Unit> {
        if (!email.contains("@")) {
            return Response.Error("That is not valid email")
        }
        return emailRepo.submitEmail(email)
    }

}