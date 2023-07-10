package com.sogya.projects.screens.mapscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sogya.projects.Constants
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentMapBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapFragment : Fragment(R.layout.fragment_map) {
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!

    private val vm: MapVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buildingId = arguments?.getInt("buildingId")
        if (buildingId != null) {
            vm.getBuilding(buildingId)
        }
        binding.toolBarMap.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.buttonDown.setOnClickListener {
            vm.setFloor(Constants.FLOOR_DOWN)
        }
        binding.buttonUp.setOnClickListener {
            vm.setFloor(Constants.FLOOR_UP)
        }
    }

    override fun onStart() {
        super.onStart()
        vm.getFloorLiveData().observe(viewLifecycleOwner) {
            it.drawableId?.let { it1 -> binding.photoView.setImageResource(it1) }
            binding.textViewFloorNumber.text = it.floorNumber.toString()
        }
        vm.getToolbarTitleLiveData().observe(viewLifecycleOwner) {
            binding.toolBarMap.title = it
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}