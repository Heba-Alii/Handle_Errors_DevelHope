package com.example.handleerrors.domain.repo

import com.example.handleerrors.ui.util.Response

interface EmailRepo {
    suspend fun submitEmail(email:String):Response<Unit>
}