package com.testsdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.langrands.mylibrary.data.IResultCallback
import com.langrands.mylibrary.data.LockerGetResData
import com.langrands.mylibrary.data.LockerResData
import com.langrands.mylibrary.services.LockerService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        val callback = object : IResultCallback<LockerGetResData> {
            override fun onSuccess(result: LockerGetResData?) {
                val aa = result
            }
        }

        LockerService().get(callback)
    }
}