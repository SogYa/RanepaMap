package com.sogya.projects.screens.mapscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentMapBinding
import com.sogya.projects.instruments.OnDataPass
import com.sogya.projects.models.Building

class MapFragment : Fragment(R.layout.fragment_map) {
    private lateinit var binding: FragmentMapBinding
    private lateinit var mOnDataPass: OnDataPass
    private lateinit var selectedBuilding: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedBuilding = arguments?.get("building").toString()
        mOnDataPass.onDataPass(selectedBuilding)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnDataPass = context as OnDataPass
    }
}