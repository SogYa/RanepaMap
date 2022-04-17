package com.sogya.projects.screens.listscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sogya.projects.R
import com.sogya.projects.databinding.FragmentListBinding
import com.sogya.projects.models.Building

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var binding: FragmentListBinding
    private var buildingsList: ArrayList<Building> = ArrayList()
    private lateinit var adapter: ListAdapter

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
        buildingsList.add(Building(1, "Первый корпус", R.drawable.building1))
        buildingsList.add(Building(1, "Второй корпус", R.drawable.korpus2))
        buildingsList.add(Building(1, "Третий корпус", R.drawable.korpus3))
        buildingsList.add(Building(1, "Пятый корпус", R.drawable.korpus5))
        buildingsList.add(Building(1, "Шестой корпус", R.drawable.korpus6))


    }

    override fun onStart() {
        super.onStart()
        adapter = ListAdapter(buildingsList) { building, _ ->
            val bundle = Bundle()
            bundle.putString("Label",building.label)
            findNavController().navigate(R.id.action_listFragment_to_mapFragment,bundle)
        }
        binding.buildingsRecyclerView.adapter = adapter


    }
}