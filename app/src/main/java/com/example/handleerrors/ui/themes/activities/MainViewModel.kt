package com.example.handleerrors.ui.themes.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.handleerrors.domain.model.EmailModel
import com.example.handleerrors.domain.usecase.SubmitEmailUseCase
import com.example.handleerrors.ui.util.DataState
import com.example.handleerrors.ui.util.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val submitEmailUseCase: SubmitEmailUseCase = SubmitEmailUseCase()) :
    ViewModel() {
    private val _emailState: MutableStateFlow<DataState<EmailModel>?> = MutableStateFlow(null)
    var emailState: MutableStateFlow<DataState<EmailModel>?> = _emailState
    private val _errorState: MutableStateFlow<DataState<EmailModel>?> = MutableStateFlow(null)
    var errorState: MutableStateFlow<DataState<EmailModel>?> = _errorState

    fun submitEmail(email: String) {
        viewModelScope.launch {
            submitEmailUseCase.mailCondition(email).apply {
                when (this) {
                    is Response.Error -> TODO()
                    is Response.Success -> TODO()
                }
            }
        }
    }
}