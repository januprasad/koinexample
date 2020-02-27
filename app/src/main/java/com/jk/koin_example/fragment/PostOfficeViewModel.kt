package com.jk.koin_example.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.jk.koin_example.network.Resource
import com.jk.koin_example.repo.PostOfficeRepo
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val viewModelModule = module {
    factory { PostOfficeViewModel(get()) }
}

class PostOfficeViewModel(private val postOfficeRepo : PostOfficeRepo) : ViewModel() {

      private val pinCode = MutableLiveData<String>()

    fun getPostOfficeResponse() {
        pinCode.value = "678503"
    }

    /*fun getPostOfficeResponse(input: String) {
        pinCode.value = input
    }*/



    var postOfficeResponse = pinCode.switchMap { res ->
        liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            emit(postOfficeRepo.getPostOfficeInfo(res))
        }
    }
}