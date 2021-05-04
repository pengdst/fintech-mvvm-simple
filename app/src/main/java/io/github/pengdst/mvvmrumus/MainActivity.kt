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

    private lateinit var btnHitungLuas: Button
    private lateinit var btnHitungKeliling: Button

    private lateinit var tvHasilKeliling: TextView
    private lateinit var tvHasilLuas: TextView

    private lateinit var edtLebar: EditText
    private lateinit var edtPanjang: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var edtAlas: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtAlas = binding.edtAlas
        edtTinggi = binding.edtTinggi
        edtPanjang = binding.edtPanjang
        edtLebar = binding.edtLebar

        tvHasilLuas = binding.tvHasilLuas
        tvHasilKeliling = binding.tvHasilKeliling

        btnHitungKeliling = binding.btnHitungKeliling
        btnHitungLuas = binding.btnHitungLuas

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