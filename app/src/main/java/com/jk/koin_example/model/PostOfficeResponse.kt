package com.jk.koin_example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.jk.koin_example.model.PostOffice

class PostOfficeResponse (
    @SerializedName("Message")
    @Expose
    var message: String? = null,
    @SerializedName("Status")
    @Expose
    var status: String? = null,
    @SerializedName("PostOffice")
    @Expose
    var postOffice: MutableList<PostOffice>? = null)