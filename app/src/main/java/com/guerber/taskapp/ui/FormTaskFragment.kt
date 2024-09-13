package com.guerber.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.FragmentDoneBinding
import com.guerber.taskapp.databinding.FragmentFormTaskBinding
import com.guerber.taskapp.utils.initToolbar
import com.guerber.taskapp.utils.showBottomSheet

class FormTaskFragment : Fragment() {

    private var _binding: FragmentFormTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormTaskBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners(){
        binding.btnCreateTask.setOnClickListener{
            validateForm()
        }
    }

    private fun validateForm(){
        val description = binding.editDescription.text.toString().trim()
        if(description.isEmpty()){
            return showBottomSheet(message = getString(R.string.description_formtask))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}