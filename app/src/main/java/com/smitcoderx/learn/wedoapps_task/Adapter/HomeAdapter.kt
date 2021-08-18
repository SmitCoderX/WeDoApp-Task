package com.smitcoderx.learn.wedoapps_task.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.smitcoderx.learn.wedoapps_task.Model.Student
import com.smitcoderx.learn.wedoapps_task.databinding.ItemLayoutBinding

class HomeAdapter(private val listener: OnClicks) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(student: Student) {
            binding.apply {
                tvName.text = student.name
                tvRoll.text = "RollNo: ${student.rollNo}"
                tvClass.text = "${student.className}th Class"
                tvMobile.text = "MobileNo: ${student.mobile_no}"
                tvMotherName.text = "Mother's Name: ${student.mother_name}"
                tvFatherName.text = "Father's Name: ${student.father_name}"

                btnEdit.setOnClickListener {
                    listener.onEdit(student)
                }

                binding.btnDelete.setOnClickListener {
                    listener.onDelete(student)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = differ.currentList[position]

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val diffUtil = object : DiffUtil.ItemCallback<Student>() {
        override fun areItemsTheSame(oldItem: Student, newItem: Student) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Student, newItem: Student) =
            oldItem == newItem
    }

    val differ = AsyncListDiffer(this, diffUtil)

    interface OnClicks {
        fun onEdit(student: Student)
        fun onDelete(student: Student)
    }

}