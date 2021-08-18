package com.smitcoderx.learn.wedoapps_task.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "student"
)

@Parcelize
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String?,
    val className: String?,
    val rollNo: String?,
    val mobile_no: String?,
    val father_name: String?,
    val mother_name: String?
) : Parcelable