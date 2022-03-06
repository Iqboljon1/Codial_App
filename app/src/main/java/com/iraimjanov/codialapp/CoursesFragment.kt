package com.iraimjanov.codialapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.iraimjanov.codialapp.Object.Object
import com.iraimjanov.codialapp.adapters.CoursesAdapter
import com.iraimjanov.codialapp.databinding.FragmentCoursesBinding
import com.iraimjanov.codialapp.models.Courses
import com.iraimjanov.codialapp.myClass.AddCourses
import com.iraimjanov.codialapp.myClass.ShowCourses

class CoursesFragment : Fragment() {
    lateinit var addCourses: AddCourses
    private lateinit var showCourses: ShowCourses
    lateinit var binding: FragmentCoursesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        loadData()
        showWindow()
        setOnClick()
        return binding.root
    }

    private fun loadData() {
        binding = FragmentCoursesBinding.inflate(layoutInflater)
        addCourses = AddCourses(requireActivity() , binding, findNavController())
        showCourses = ShowCourses(requireActivity(), binding , findNavController())
    }

    private fun showWindow() {
        binding.tvAllCourses.text = Object.tvAllCoursesName
        if (Object.booleanAddCourses) {
            binding.imageAdd.visibility = View.VISIBLE
            binding.lyAdd.visibility = View.VISIBLE
        }
        requireActivity().window.statusBarColor = Color.parseColor("#c78800")
        showCourses.showCourses()
    }

    private fun setOnClick() {
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.lyAdd.setOnClickListener {
            addCourses.buildDialog()
        }
    }

}