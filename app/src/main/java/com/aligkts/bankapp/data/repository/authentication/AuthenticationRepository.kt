package com.aligkts.bankapp.data.repository.authentication

import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.model.request.LoginRequestModel
import com.aligkts.bankapp.data.model.response.LoginResponse

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface AuthenticationRepository {
    suspend fun login(loginRequest: LoginRequestModel) : AppResult<LoginResponse>
}