package com.sogya.projects.screens.listscreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentListBinding
import com.sogya.projects.instruments.BuildingsEnum
import com.sogya.projects.instruments.OnDataPass
import com.sogya.projects.models.Building


class ListFragment : Fragment(R.layout.fragment_list), ListAdapter.OnBuildingClickListener {
    private lateinit var binding: FragmentListBinding
    private var buildingsList: ArrayList<Building> = ArrayList()
    private lateinit var adapter: ListAdapter
    private lateinit var mOnDataPass: OnDataPass

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = GridLayoutManager(context, 2)
        binding.buildingsRecyclerView.layoutManager = layoutManager
        adapter = ListAdapter(this)
        binding.buildingsRecyclerView.adapter = adapter
        if (buildingsList.isEmpty()) {
            buildingsList.add(Building(BuildingsEnum.FIRST, "Первый корпус"))
            buildingsList.add(Building(BuildingsEnum.SECOND, "Второй корпус"))
            buildingsList.add(Building(BuildingsEnum.THIRD, "Третий корпус"))
            buildingsList.add(Building(BuildingsEnum.FIVE, "Пятый корпус"))
            buildingsList.add(Building(BuildingsEnum.SIX, "Шестой корпус"))
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.updateBuildingList(buildingsList)
        mOnDataPass.onDataPass("Главная")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnDataPass = context as OnDataPass
    }

    override fun onClick(building: Building) {
        findNavController().navigate(
            R.id.action_listFragment_to_mapFragment,
            bundleOf("building" to building.label)
        )
    }
}