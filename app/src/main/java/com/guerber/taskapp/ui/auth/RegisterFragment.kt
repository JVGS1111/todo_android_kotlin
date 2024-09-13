package com.guerber.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.FragmentLoginBinding
import com.guerber.taskapp.databinding.FragmentRegisterBinding
import com.guerber.taskapp.utils.initToolbar
import com.guerber.taskapp.utils.showBottomSheet

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListeners()
    }

    private fun initListeners(){
        binding.btnRegister.setOnClickListener{
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        val confirmPassword = binding.edtConfirmPassword.text.toString().trim()

        if(email.isEmpty()){
            return showBottomSheet(message = getString(R.string.email_empty_register_fragment))
        }
        if(password.isEmpty()){
            return showBottomSheet(message = getString(R.string.password_empty_register_fragment))
        }
        if(confirmPassword.isEmpty()){
            return showBottomSheet(message = getString(R.string.confirm_password_empty_register_fragment))
        }
        if(confirmPassword != password){
            return showBottomSheet(message = getString(R.string.confirmation_password_does_not_match_register_fragment))
        }

        Toast.makeText(requireContext(), "Tudo certo", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}