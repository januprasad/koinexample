package com.jk.koin_example

import com.jk.koin_example.model.PostOffice
import com.jk.koin_example.network.PostOfficeApi
import com.jk.koin_example.network.Resource
import com.jk.koin_example.network.ResponseHandler
import com.jk.koin_example.repo.PostOfficeRepo
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import retrofit2.HttpException

@RunWith(JUnit4::class)
class PostOfficeApiTests {

    private lateinit var postOfficeApi: PostOfficeApi
    private val validPinCode = "678503"
    private val responseHandler = ResponseHandler()
    private lateinit var repository: PostOfficeRepo
    private val postOffice = PostOffice(""
        ,""
        ,""
        ,""
    ,"","","","","","","","")

    private val postOfficeResponse = Resource.success(postOffice)

    @Before
    fun setUp(){

        postOfficeApi = mock()
        val mockException: HttpException = mock()
        whenever(mockException.code()).thenReturn(401)
        runBlocking {
            whenever(postOfficeApi.getPinCodeInfo(eq(validPinCode))).thenThrow(mockException)
//            whenever(postOfficeApi.getForecast(eq(validLocation), Mockito.anyString())).thenReturn(weather)
        }
        repository = PostOfficeRepo(
            postOfficeApi,
            responseHandler
        )
    }
    @Test
    fun `test getPinCodeInfo when valid pin code is requested, then post office is returned`() =
        runBlocking {
            Assert.assertEquals(postOfficeResponse, repository.getPostOfficeInfo(validPinCode))
        }


}