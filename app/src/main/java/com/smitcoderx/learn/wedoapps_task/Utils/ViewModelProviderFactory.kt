package com.smitcoderx.learn.wedoapps_task.Utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.smitcoderx.learn.wedoapps_task.Repository.StudentRepository
import com.smitcoderx.learn.wedoapps_task.UI.StudentViewModel

class ViewModelProviderFactory(
    val app: Application,
    val repository: StudentRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StudentViewModel(app, repository) as T
    }
}