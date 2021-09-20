package com.example.myapplication.ui.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.hot.R
import com.example.hot.databinding.TopHalfFragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit


 class FragmentTopHalf : BaseFragment<TopHalfFragmentBinding>()  {

    override val LOG_TAG: String = "Top_Half_Fragment"
    override val bindingInflater: (LayoutInflater) ->
    TopHalfFragmentBinding = TopHalfFragmentBinding::inflate

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val view = inflater.inflate(R.layout.top_half_fragment, container , false )
         bundle("")
         return view
    }

     private fun bundle(it: String) {

         val bundle = Bundle()
         bundle.putString(DATA , it)

         val fragment = FragmentBottomHalf()
         fragment.arguments = bundle

         val bottomFragment = R.id.bottom_fragment
         fragmentManager?.beginTransaction()?.replace(bottomFragment,fragment)?.commit()
     }


     override fun setUp() {
        initObservable()
    }

    private fun initObservable() {
        PublishSubject.create<String> { emitter ->
            binding?.top?.doOnTextChanged { text, start, before, count ->
                emitter.onComplete()
            }
        }.debounce(1500, TimeUnit.SECONDS)
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(
                {
                    bundle(it)
                    Log.i(TAG, "$it")

                },
                { error ->
                    Log.i(TAG, "error: ${error?.message}")
                }
         )


    }

     override fun addCallbacks() {}
 }
