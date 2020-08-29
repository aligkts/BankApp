package com.aligkts.bankapp.data.api

import com.aligkts.bankapp.data.model.request.LoginRequestModel
import com.aligkts.bankapp.data.model.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface BankApi {

    @GET("/accounts")
    suspend fun getAccounts(): Response<List<String>>

    @POST("/authenticate")
    suspend fun login(loginRequestBody: LoginRequestModel): Response<LoginResponse>
}