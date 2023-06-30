package com.sogya.projects.screens.listscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentListBinding
import ru.sogya.projects.domain.models.Building

class ListFragment : Fragment(R.layout.fragment_list), ListAdapter.OnBuildingClickListener {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListAdapter
    private lateinit var mOnDataPass: OnDataPass

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
        val vm: ListVM = ViewModelProvider(this).get(ListVM::class.java)

        val layoutManager = GridLayoutManager(context, 2)
        binding.buildingsRecyclerView.layoutManager = layoutManager
        adapter = ListAdapter(this)
        binding.buildingsRecyclerView.adapter = adapter

        vm.buildingListLiveData.observe(viewLifecycleOwner) {
            adapter.updateBuildingList(it)
            binding.loadingLayout.visibility = GONE
        }

        mOnDataPass.onDataPass(getString(R.string.main_title))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnDataPass = context as OnDataPass
    }

    override fun onClick(building: ru.sogya.projects.domain.models.Building) {
        findNavController().navigate(
            R.id.action_listFragment_to_mapFragment,
            bundleOf("buildingId" to building.buildingId)
        )
    }
}