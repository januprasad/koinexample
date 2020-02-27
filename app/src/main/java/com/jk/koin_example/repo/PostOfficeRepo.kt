package com.jk.koin_example.repo

import com.jk.koin_example.model.PostOfficeResponse
import com.jk.koin_example.network.PostOfficeApi
import com.jk.koin_example.network.Resource
import com.jk.koin_example.network.ResponseHandler
import org.koin.dsl.module
import java.lang.Exception

val postOfficeRepo = module {
    factory { PostOfficeRepo(get(), get()) }
}
open class PostOfficeRepo(private val postOfficeApi: PostOfficeApi, private val responseHandler:ResponseHandler) {
    suspend fun getPostOfficeInfo(pinCode:String): Resource<MutableList<PostOfficeResponse>> {

        return try {
            val response = postOfficeApi.getPinCodeInfo(pinCode)
            return responseHandler.handleSuccess(response)
        }catch (e : Exception){
            responseHandler.handleException(e)
        }
    }
}