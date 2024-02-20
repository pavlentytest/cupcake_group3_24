package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFlavorBinding


class FlavorFragment : Fragment() {

    private var flavorBinding: FragmentFlavorBinding? = null
    private val myViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        flavorBinding = FragmentFlavorBinding.inflate(inflater,container,false)
        return flavorBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flavorBinding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = myViewModel
        }
        flavorBinding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
        }
    }

}