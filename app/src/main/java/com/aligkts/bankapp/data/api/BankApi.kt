package com.aligkts.bankapp.data.api

import com.aligkts.bankapp.data.model.request.LoginRequestModel
import com.aligkts.bankapp.data.model.response.AccountResponse
import com.aligkts.bankapp.data.model.response.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface BankApi {

    @GET("/accounts")
    suspend fun getAccounts(@Query("customer_id") id: Int): Response<AccountResponse>

    @POST("/authenticate")
    suspend fun login(@Body loginRequestBody: LoginRequestModel): Response<LoginResponse>
}