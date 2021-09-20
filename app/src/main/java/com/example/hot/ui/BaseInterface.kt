package com.example.myapplication.ui

import android.util.Log
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

 interface BaseInterface  < VB: ViewBinding> {



        val LOG_TAG  : String

        var _binding: ViewBinding?

        val bindingInflater: (LayoutInflater) -> VB

        val binding
            get() =  _binding as VB?

        fun setUp()

        fun log(value: Any){
            Log.v(LOG_TAG,value.toString())
        }



}