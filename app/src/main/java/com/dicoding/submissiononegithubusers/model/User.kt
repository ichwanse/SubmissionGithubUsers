package com.dicoding.submissiononegithubuser.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String = "",
    val name: String = "",
    val avatar: Int?,
    val company: String = "",
    val location: String = "",
    val repository: Int = 0,
    val follower: Int = 0,
    val following: Int = 0
) : Parcelable
