package com.example.myapplication.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hot.R
import com.example.hot.databinding.BottomHalfFragmentBinding


class FragmentBottomHalf : BaseFragment<BottomHalfFragmentBinding>()  {


    override val LOG_TAG: String = "Bottom_Half_Fragment"

    override val bindingInflater: (LayoutInflater) ->
    BottomHalfFragmentBinding = BottomHalfFragmentBinding::inflate

    override fun addCallbacks() {}

    override fun setUp() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_half_fragment, container , false )
        bundle()
        return view
    }

    private fun bundle() {
        val args = this.arguments
        val inputData = args?.get(DATA)
        binding?.bottom?.text = inputData.toString()
    }


}

