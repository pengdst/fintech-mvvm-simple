package io.github.pengdst.mvvmrumus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val luasPersegiPanjang = MutableLiveData<Float>()

    fun hitungPersegiPanjang(panjang: Float, lebar: Float){
        val luas = panjang * lebar

        luasPersegiPanjang.postValue(luas)
    }

    fun observeLuasPersegiPanjang(): LiveData<Float> = luasPersegiPanjang
}