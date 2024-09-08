package com.guerber.taskapp.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.FragmentRecoveryAccountBinding
import com.guerber.taskapp.databinding.FragmentRegisterBinding


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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}