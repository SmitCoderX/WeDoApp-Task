package com.smitcoderx.learn.wedoapps_task.UI.Fragments.EditSave

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smitcoderx.learn.wedoapps_task.Model.Student
import com.smitcoderx.learn.wedoapps_task.R
import com.smitcoderx.learn.wedoapps_task.UI.MainActivity
import com.smitcoderx.learn.wedoapps_task.UI.StudentViewModel
import com.smitcoderx.learn.wedoapps_task.databinding.FragmentSaveBinding

class SaveFragment : Fragment(R.layout.fragment_save) {

    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel: StudentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSaveBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel

        binding.apply {
            btnSubmit.setOnClickListener {
                val student = Student(
                    null, etName.text.toString(),
                    etClassName.text.toString(),
                    etRollNo.text.toString(),
                    etMobile.text.toString(),
                    etMotherName.text.toString(),
                    etFatherName.text.toString()
                )
                viewModel.saveStudent(student)
                findNavController().popBackStack()
            }

        }
    }

}