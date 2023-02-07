package com.example.lab7recyclerviewdialog2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab7recyclerviewdialog2022.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /// Set RecyclerView
        studentData()
        binding.recyclerView.adapter = StudentsAdapter(this.studentList, applicationContext)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val itemDecor = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(itemDecor)

        /// Click Add Student
        binding.btnAddStudent.setOnClickListener {
            val mDialogView = LayoutInflater.from(
                this).inflate(R.layout.add_dialog_layout,null)
            val myBuilder = AlertDialog.Builder(this) //,R.style.CustomAlertDialog
            myBuilder.setView(mDialogView)
            ///Save Button
            myBuilder.setPositiveButton("Save" ) { dialog, which ->
                val id = mDialogView.findViewById(R.id.edtId) as TextInputEditText
                val name = mDialogView.findViewById(R.id.edtName) as TextInputEditText
                val age = mDialogView.findViewById(R.id.edtAge) as TextInputEditText
                studentList.add(
                    Student(id.text.toString(),name.text.toString(),age.text.toString().toInt()))

                binding.recyclerView.adapter?.notifyDataSetChanged()
                Toast.makeText(
                    applicationContext,
                    "The student is added successfully",
                    Toast.LENGTH_LONG
                ).show()
            }
            ///Cancel Button
            myBuilder.setNegativeButton("Cancel",) { dialog, which ->
                dialog.dismiss()
            }
            myBuilder.show() }
    }

    fun studentData() {
        //prepare student data for testing
        studentList.add(Student("621234567-8", "Alice", 20))
        studentList.add(Student("629876543-2", "Bob", 21))
    }
}