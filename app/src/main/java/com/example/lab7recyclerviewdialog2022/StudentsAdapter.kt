package com.example.lab7recyclerviewdialog2022

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab7recyclerviewdialog2022.databinding.StdItemLayoutBinding

class StudentsAdapter(val studentList: ArrayList<Student>?, val context:Context):
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    class ViewHolder(view: View, val binding: StdItemLayoutBinding) :
        RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StdItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding

        binding.txtId.text = "ID: ${studentList!![position].id}"
        binding.txtName.text = "Name: ${studentList!![position].name}"
        binding.txtAge.text = "Age: ${studentList!![position].age.toString()}"
    }

    override fun getItemCount(): Int {
        return  studentList!!.size
    }
}
