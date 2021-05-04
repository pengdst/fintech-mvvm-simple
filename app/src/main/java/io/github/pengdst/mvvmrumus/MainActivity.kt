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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edtPanjang = binding.edtPanjang
        edtLebar = binding.edtLebar

        tvHasilLuas = binding.tvHasilLuas
        tvHasilKeliling = binding.tvHasilKeliling

        btnHitungKeliling = binding.btnHitungKeliling
        btnHitungLuas = binding.btnHitungLuas

        initViewModel()
        subscribeViewModel()

        btnHitungLuas.setOnClickListener {
            val panjang = edtPanjang.text.toString().trim().toDouble()
            val lebar = edtLebar.text.toString().trim().toDouble()

            viewModel.hitungLuasPersegiPanjang(panjang, lebar)
        }

        btnHitungKeliling.setOnClickListener {
            val panjang = edtPanjang.text.toString().trim().toDouble()
            val lebar = edtLebar.text.toString().trim().toDouble()

            viewModel.hitungKelilingPersegiPanjang(panjang, lebar)
        }
    }

    private fun subscribeViewModel() {
        viewModel.observeLuasPersegiPanjang().observe(this) { luas ->
            tvHasilLuas.text = "Hasil Luas: $luas"
        }

        viewModel.observeKelilingPersegiPanjang().observe(this) { keliling ->
            tvHasilKeliling.text = "Hasil Keliling: $keliling"
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}