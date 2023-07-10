package com.sogya.projects.screens.listscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListAdapter
    private val vm: ListVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.buildingsRecyclerView.layoutManager = layoutManager
        adapter = ListAdapter()
        adapter.setOnClickListener(object : ListAdapter.OnClickListener {
            override fun onClick(buildingId: Int) {
                findNavController().navigate(
                    R.id.action_listFragment_to_mapFragment,
                    bundleOf("buildingId" to buildingId)
                )
            }
        })
        binding.buildingsRecyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        vm.getBuildingLiveData().observe(viewLifecycleOwner) {
            adapter.updateBuildingList(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}