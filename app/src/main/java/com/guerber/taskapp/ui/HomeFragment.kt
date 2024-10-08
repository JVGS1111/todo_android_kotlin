package com.guerber.taskapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.guerber.taskapp.R
import com.guerber.taskapp.databinding.FragmentHomeBinding
import com.guerber.taskapp.databinding.FragmentSplashBinding
import com.guerber.taskapp.ui.adapter.ViewPageAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
    }

    private fun initTabs(){
        val pageAdapter = ViewPageAdapter(requireActivity())
        binding.viewPager.adapter = pageAdapter

        pageAdapter.addFragment(TodoFragment(),R.string.status_task_todo)
        pageAdapter.addFragment(DoingFragment(),R.string.status_task_doing)
        pageAdapter.addFragment(DoneFragment(),R.string.status_task_done)

        binding.viewPager.offscreenPageLimit = pageAdapter.itemCount

        TabLayoutMediator(binding.tabs, binding.viewPager){ tab, position ->
            tab.text = getString(pageAdapter.getTitle(position))

        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}