package io.github.pengdst.mvvmrumus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val luasPersegiPanjang = MutableLiveData<Double>()
    private val kelilingPersegiPanjang = MutableLiveData<Double>()

    fun hitungLuasPersegiPanjang(panjang: Double, lebar: Double){
        val luas = panjang * lebar

        luasPersegiPanjang.postValue(luas)
    }

    fun hitungKelilingPersegiPanjang(panjang: Double, lebar: Double) {
        val hasil = 2 * (panjang * lebar)
        kelilingPersegiPanjang.postValue(hasil)
    }

    fun observeLuasPersegiPanjang(): LiveData<Double> = luasPersegiPanjang
    fun observeKelilingPersegiPanjang(): LiveData<Double> = kelilingPersegiPanjang
}