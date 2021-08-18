package com.smitcoderx.learn.wedoapps_task.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.smitcoderx.learn.wedoapps_task.Model.Student
import com.smitcoderx.learn.wedoapps_task.Repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(
    app: Application,
    val repository: StudentRepository
) : AndroidViewModel(app) {

    fun saveStudent(student: Student) = viewModelScope.launch {
        repository.upsert(student)
    }

    fun deleteStudent(student: Student) = viewModelScope.launch {
        repository.delete(student)
    }

    fun updateStudent(student: Student) = viewModelScope.launch {
        repository.update(student)
    }

    fun getAll() = repository.allStudents()

}