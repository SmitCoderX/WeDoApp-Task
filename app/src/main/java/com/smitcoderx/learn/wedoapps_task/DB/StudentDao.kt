package com.smitcoderx.learn.wedoapps_task.DB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.smitcoderx.learn.wedoapps_task.Model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("SELECT * FROM student")
    fun getAllStudents(): LiveData<List<Student>>

}