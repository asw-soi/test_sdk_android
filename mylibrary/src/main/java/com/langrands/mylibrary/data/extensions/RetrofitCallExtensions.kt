package com.langrands.mylibrary.data.extensions

import com.langrands.mylibrary.data.ICallback
import com.langrands.mylibrary.data.IResponse
import com.langrands.mylibrary.data.IResultCallback
import com.langrands.mylibrary.data.toApiCallback
import retrofit2.Call

object RetrofitCallExtensions {
    inline fun <reified TR : IResponse> Call<TR>.enqueue(callback: ICallback) {
        enqueue(callback.toApiCallback<TR>())
    }

    inline fun <reified TR : IResponse> Call<TR>.enqueue(callback: IResultCallback<TR>) {
        enqueue(callback.toApiCallback())
    }
}