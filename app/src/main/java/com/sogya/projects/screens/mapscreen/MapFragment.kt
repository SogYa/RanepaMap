package com.sogya.projects.screens.mapscreen

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
            Log.d("Uri", it.imageUri)
            Glide.with(requireContext()).load(it.imageUri)
                .placeholder(R.drawable.ranepa_logo)
                .error(R.drawable.ranepa_logo)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .encodeFormat(SvgEncoder())
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        Log.d("Error", e.toString())
                        Toast.makeText(requireContext(), e.toString(), Toast.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.loadingLayout.visibility = GONE
                        return false
                    }
                })
                .into(binding.photoView)
            binding.textViewFloorNumber.text = it.floorNumber.toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}