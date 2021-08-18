package com.smitcoderx.learn.wedoapps_task.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.smitcoderx.learn.wedoapps_task.DB.StudentDatabase
import com.smitcoderx.learn.wedoapps_task.R
import com.smitcoderx.learn.wedoapps_task.Repository.StudentRepository
import com.smitcoderx.learn.wedoapps_task.Utils.ViewModelProviderFactory
import com.smitcoderx.learn.wedoapps_task.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: StudentViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = StudentRepository(StudentDatabase(this))
        val viewModelProvider = ViewModelProviderFactory(application, repository)
        viewModel =
            ViewModelProvider(this, viewModelProvider)[StudentViewModel::class.java]
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
    }
}