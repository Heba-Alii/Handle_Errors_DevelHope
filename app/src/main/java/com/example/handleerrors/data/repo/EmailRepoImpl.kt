package com.example.handleerrors.data.repo

import com.example.handleerrors.domain.repo.EmailRepo
import com.example.handleerrors.ui.util.Response
import kotlinx.coroutines.delay
import kotlin.random.Random

class EmailRepoImpl() : EmailRepo {
    override suspend fun submitEmail(email: String): Response<Unit> {
        delay(500L)
        return if (Random.nextBoolean()) {
            Response.Success(Unit)
        } else
            if (Random.nextBoolean()) {
                Response.Error("Server Error")
            } else {
                Response.Error("Not Authenticated Error")
            }
    }
}



