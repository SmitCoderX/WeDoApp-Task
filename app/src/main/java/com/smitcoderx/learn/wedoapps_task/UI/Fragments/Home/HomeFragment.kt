package com.smitcoderx.learn.wedoapps_task.UI.Fragments.Home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.smitcoderx.learn.wedoapps_task.Adapter.HomeAdapter
import com.smitcoderx.learn.wedoapps_task.Model.Student
import com.smitcoderx.learn.wedoapps_task.R
import com.smitcoderx.learn.wedoapps_task.UI.MainActivity
import com.smitcoderx.learn.wedoapps_task.UI.StudentViewModel
import com.smitcoderx.learn.wedoapps_task.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.OnClicks {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: StudentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        viewModel = (activity as MainActivity).viewModel
        val homeAdapter = HomeAdapter(this)
        binding.rvHome.apply {
            setHasFixedSize(true)
            adapter = homeAdapter
        }

        viewModel.getAll().observe(viewLifecycleOwner) {
            homeAdapter.differ.submitList(it)
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToSaveFragment()
            )
        }
    }

    override fun onEdit(student: Student) {
        val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(student)
        findNavController().navigate(action)
    }

    override fun onDelete(student: Student) {
        viewModel.deleteStudent(student)
    }

}