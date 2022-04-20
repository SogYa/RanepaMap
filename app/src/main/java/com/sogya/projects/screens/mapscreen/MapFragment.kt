package com.sogya.projects.screens.mapscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentMapBinding
import com.sogya.projects.instruments.OnDataPass
import com.sogya.projects.instruments.myCallBack

class MapFragment : Fragment(R.layout.fragment_map) {
    private lateinit var binding: FragmentMapBinding
    private lateinit var mOnDataPass: OnDataPass

    private lateinit var vm: MapVM

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
        vm = ViewModelProvider(this).get(MapVM::class.java)
        vm.buildingId = arguments?.getInt("buildingId")
        vm.setDefault()
        vm.buildingTitleLiveData.observe(viewLifecycleOwner) {
            mOnDataPass.onDataPass(it)
        }

        binding.buttonDown.setOnClickListener {
            vm.goDown(
                object : myCallBack<Boolean> {
                    override fun data(t: Boolean) {
                        Toast.makeText(
                            context,
                            getString(R.string.toast_floor_down_attention),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
        binding.buttonUp.setOnClickListener {
            vm.goUp(
                object : myCallBack<Boolean> {
                    override fun data(t: Boolean) {
                        Toast.makeText(
                            context,
                            getString(R.string.toast_floor_up_attention),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
        vm.floorNumberLiveData.observe(viewLifecycleOwner) {
            binding.textViewFloorNumber.text = it.toString()
        }
        vm.floorResourceLiveData.observe(viewLifecycleOwner) {
            binding.loadingLayout.visibility = GONE
            binding.photoView.setImageResource(it)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnDataPass = context as OnDataPass
    }
}