package com.smitcoderx.learn.wedoapps_task.Repository

import com.smitcoderx.learn.wedoapps_task.DB.StudentDatabase
import com.smitcoderx.learn.wedoapps_task.Model.Student

class StudentRepository(
    val db: StudentDatabase
) {

    suspend fun upsert(student: Student) = db.getStudentDao().upsert(student)

    suspend fun delete(student: Student) = db.getStudentDao().delete(student)

    suspend fun update(student: Student) = db.getStudentDao().update(student)

    fun allStudents() = db.getStudentDao().getAllStudents()

}