package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentPickupBinding
import com.example.myapplication.databinding.FragmentStartBinding

class PickupFragment : Fragment() {


    private var pickupBinding: FragmentPickupBinding? = null
    private val myViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pickupBinding = FragmentPickupBinding.inflate(inflater, container, false)
        return pickupBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pickupBinding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = myViewModel
        }
        pickupBinding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_pickupFragment_to_summaryFragment)
        }
    }


}