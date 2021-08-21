package com.langrands.mylibrary.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class NullCallback : ICallback

interface IResponse : Serializable {
}

/**
 * アプリ内の共通コールバック
 *
 */
interface ICallback : IFailureCallback {
    fun onSuccess() {}
}

/**
 * アプリ内の共通コールバック
 *
 * @param T
 */
interface IResultCallback<T> : IFailureCallback {
    fun onSuccess(result: T? = null)
}

/**
 * アプリ内の共通エラーコールバック
 *
 */
interface IFailureCallback {
    fun onFailure(error: Error) {}
}


/**
 * ICallback Map to Api Callback
 *
 * @param T
 * @return
 */
inline fun <reified T : IResponse> ICallback.toApiCallback(): Callback<T> {
    val self = this
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {

                self.onSuccess()
            } else {

            }
        }

        override fun onFailure(call: Call<T?>, t: Throwable) {

        }
    }
}

/**
 * IResultCallback Map to Api Callback
 *
 * @param T
 * @return
 */
inline fun <reified T : IResponse> IResultCallback<T>.toApiCallback(): Callback<T> {
    val self = this
    return object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                val body = response.body()
                self.onSuccess(body)
            } else {

            }
        }

        override fun onFailure(call: Call<T?>, t: Throwable) {

        }
    }
}
