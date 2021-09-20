package com.example.hot.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hot.R
import com.example.hot.databinding.ActivityMainBinding
import com.example.myapplication.ui.fragments.FragmentTopHalf
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.top_fragment, FragmentTopHalf()).commit()

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

}