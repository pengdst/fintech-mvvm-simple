package io.github.pengdst.mvvmrumus

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        binding.btnHitungLuas.setOnClickListener {
            val panjang = binding.edtPanjang.text.toString().trim().toDouble()
            val lebar = binding.edtLebar.text.toString().trim().toDouble()

            viewModel.hitungLuasPersegiPanjang(panjang, lebar)
        }

        binding.btnHitungKeliling.setOnClickListener {
            val panjang = binding.edtPanjang.text.toString().trim().toDouble()
            val lebar = binding.edtLebar.text.toString().trim().toDouble()

            viewModel.hitungKelilingPersegiPanjang(panjang, lebar)
        }
    }

    private fun subscribeViewModel() {
        viewModel.observeLuasPersegiPanjang().observe(this) { luas ->
            binding.tvHasilLuas.text = "Hasil Luas: $luas"
        }

        viewModel.observeKelilingPersegiPanjang().observe(this) { keliling ->
            binding.tvHasilKeliling.text = "Hasil Keliling: $keliling"
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}