package com.langrands.mylibrary.data

import java.io.Serializable

data class LockerGetReqData(
    val spacerIds: List<String>
)

data class LockerGetResData(
    val spacers: List<LockerResData>?
) : Serializable, IResponse

data class LockerResData(
    val id: String,
    val status: String,
    val size: String?
) : Serializable