package com.langrands.mylibrary.data

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ILockerAPI {
    @POST("exApp/locker/spacer/get")
    fun get(@Body params: LockerGetReqData): Call<LockerGetResData>
}