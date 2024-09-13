package com.guerber.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.guerber.taskapp.databinding.FragmentLoginBinding
import com.guerber.taskapp.R
import com.guerber.taskapp.utils.showBottomSheet

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.initListeners()
    }

    private fun initListeners(){
        binding.btnLogin.setOnClickListener{
            validateData()
           // findNavController().navigate(R.id.action_global_homeFragment)
        }
        binding.btnRegister.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.btnRecovery.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_recoveryAccountFragment)
        }
    }

    private fun validateData(){
        val email = binding.editEmail.text.toString().trim()
        val password = binding.editPassword.text.toString().trim()
        //return  findNavController().navigate(R.id.action_global_homeFragment)
        if(email.isEmpty()){
            return showBottomSheet(message = getString(R.string.email_empty))
        }
        if(password.isEmpty()){
            return showBottomSheet(message = getString(R.string.password_empty))
        }

        findNavController().navigate(R.id.action_global_homeFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}