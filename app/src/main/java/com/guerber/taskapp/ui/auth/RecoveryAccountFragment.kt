package com.guerber.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.FragmentRecoveryAccountBinding
import com.guerber.taskapp.databinding.FragmentRegisterBinding
import com.guerber.taskapp.utils.initToolbar
import com.guerber.taskapp.utils.showBottomSheet


class RecoveryAccountFragment : Fragment() {


    private var _binding: FragmentRecoveryAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecoveryAccountBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }
    private fun initListeners(){
        binding.btnRecovery.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.editEmail.text.toString().trim()

        if(email.isEmpty()){
            return showBottomSheet(message = R.string.email_empty)
        }

        Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}