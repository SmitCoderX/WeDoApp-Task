package com.smitcoderx.learn.wedoapps_task.UI.Fragments.EditSave

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.smitcoderx.learn.wedoapps_task.Model.Student
import com.smitcoderx.learn.wedoapps_task.R
import com.smitcoderx.learn.wedoapps_task.UI.MainActivity
import com.smitcoderx.learn.wedoapps_task.UI.StudentViewModel
import com.smitcoderx.learn.wedoapps_task.databinding.FragmentEditBinding

class EditFragment : Fragment(R.layout.fragment_edit) {

    private lateinit var binding: FragmentEditBinding
    private lateinit var viewModel: StudentViewModel
    private val args by navArgs<EditFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditBinding.bind(view)


        viewModel = (activity as MainActivity).viewModel
        val studentArgs = args.student
        binding.apply {
            etName.setText(studentArgs.name)
            etClassName.setText(studentArgs.className)
            etRollNo.setText(studentArgs.rollNo)
            etMobile.setText(studentArgs.mobile_no)
            etMotherName.setText(studentArgs.mother_name)
            etFatherName.setText(studentArgs.father_name)
        }

        binding.fabEdit.setOnClickListener {
            allEnabled()
        }


        binding.apply {
            fabSave.setOnClickListener {
                allDisabled()
                val student = Student(
                    studentArgs.id, etName.text.toString(),
                    etClassName.text.toString(),
                    etRollNo.text.toString(),
                    etMobile.text.toString(),
                    etMotherName.text.toString(),
                    etFatherName.text.toString()
                )
                viewModel.updateStudent(student)
                findNavController().popBackStack()
            }
        }
    }

    private fun allEnabled() {
        binding.apply {
            fabSave.show()
            fabEdit.hide()
            etName.isEnabled = true
            etClassName.isEnabled = true
            etRollNo.isEnabled = true
            etMobile.isEnabled = true
            etMotherName.isEnabled = true
            etFatherName.isEnabled = true
        }
    }

    private fun allDisabled() {
        binding.apply {
            fabEdit.show()
            fabSave.hide()
            etName.isEnabled = false
            etClassName.isEnabled = false
            etRollNo.isEnabled = false
            etMotherName.isEnabled = false
            etMotherName.isEnabled = false
            etFatherName.isEnabled = false
        }
    }
}