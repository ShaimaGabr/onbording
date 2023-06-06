package com.example.onbording

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.onbording.adapter.OverAdapter
import com.example.onbording.databinding.FragmentHomeBinding
import com.example.onbording.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homMvvm: HomeViewModel by viewModels()
    private lateinit var overAdapter: OverAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overAdapter= OverAdapter()

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getOverMeal()
        setUpOverRecView()
    }
    private fun getOverMeal(){
        homMvvm.getOverMeals()
        homMvvm.getOverMealLiveData.observe(viewLifecycleOwner){ data->
            overAdapter.differ.submitList(data)
        }
    }
    private fun setUpOverRecView(){
        binding.overRecycler.apply {
            adapter=overAdapter
        }
    }

}