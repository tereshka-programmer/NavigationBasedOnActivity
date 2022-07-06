package com.example.navigationbasedonactivity.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Options(
    val boxCount: Int,
    val isTimerEnabled: Boolean
) : Parcelable {

    companion object {
        val DEFAULT = Options(boxCount = 3, isTimerEnabled = false)
    }
}
