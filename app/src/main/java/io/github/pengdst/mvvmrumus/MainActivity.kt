package io.github.pengdst.mvvmrumus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import io.github.pengdst.mvvmrumus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        viewModel.observeLuasPersegiPanjang().observe(this) { luas ->

        }

        viewModel.observeKelilingPersegiPanjang().observe(this) { keliling ->

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}