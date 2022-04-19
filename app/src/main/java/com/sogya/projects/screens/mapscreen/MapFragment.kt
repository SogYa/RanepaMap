package com.sogya.projects.screens.mapscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentMapBinding
import com.sogya.projects.instruments.Constants
import com.sogya.projects.instruments.OnDataPass
import com.sogya.projects.models.Building

class MapFragment : Fragment(R.layout.fragment_map) {
    private lateinit var binding: FragmentMapBinding
    private lateinit var mOnDataPass: OnDataPass
    private lateinit var selectedBuilding: Building
    private var floorCounter = Constants.MINIMAL_FLOOR_NUMBER
    private var floorResource: Int = Constants.DEFAULT_RESORCE_FOR_MAP_FRAGMENT

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
        selectedBuilding = arguments?.getSerializable("building") as Building
        mOnDataPass.onDataPass(selectedBuilding.label)
    }

    override fun onStart() {
        super.onStart()
        setFloor()
        binding.photoView.setImageResource(setFloorResource())
        binding.textViewFloorNumber.text = floorCounter.toString()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnDataPass = context as OnDataPass
    }

    private fun setFloor() {

        binding.buttonDown.setOnClickListener {
            if (floorCounter > Constants.MINIMAL_FLOOR_NUMBER) {
                floorCounter--
            } else {
                Toast.makeText(
                    context,
                    getString(R.string.toast_floor_down_attention),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.buttonUp.setOnClickListener {
            if (floorCounter < selectedBuilding.floorNumber) {
                floorCounter++
            } else {
                Toast.makeText(
                    context,
                    getString(R.string.toast_floor_up_attention),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun setFloorResource(): Int {
        when (floorCounter) {
            1 -> floorResource = selectedBuilding.buildingsFloorsEnums.firstFloorResource
            2 -> floorResource = selectedBuilding.buildingsFloorsEnums.secondFloorResource
            3 -> floorResource = selectedBuilding.buildingsFloorsEnums.thirdFloorResource!!
            4 -> floorResource = selectedBuilding.buildingsFloorsEnums.fourFloorResource!!
            5 -> floorResource = selectedBuilding.buildingsFloorsEnums.fiveFloorResource!!
            6 -> floorResource = selectedBuilding.buildingsFloorsEnums.sixFloorResource!!
        }
        return floorResource
    }
}