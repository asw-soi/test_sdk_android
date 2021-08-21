package com.langrands.mylibrary.services

import com.langrands.mylibrary.data.*
import com.langrands.mylibrary.data.extensions.RetrofitCallExtensions.enqueue

class LockerService {
    fun get(callback: IResultCallback<LockerGetResData>){


        val params = LockerGetReqData(listOf("SPACER055"))
        api.locker.get(params).enqueue(callback)
    }
}