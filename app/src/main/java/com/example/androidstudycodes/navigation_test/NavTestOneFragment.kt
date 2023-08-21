package com.example.androidstudycodes.navigation_test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.androidstudycodes.R

class NavTestOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = inflater.inflate(R.layout.fragment_nav_test_one, container, false)

        val text = binding.findViewById<TextView>(R.id.tv_one)
        val customObject = CustomObject("asdf", "asdf")
        val action = NavTestOneFragmentDirections.actionNavTestOneFragmentToNavTestTwoFragment(customObject)
        text.setOnClickListener { findNavController().navigate(action) }

        return binding.rootView
    }
}