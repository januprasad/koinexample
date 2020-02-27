package com.jk.koin_example.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostOffice(
    @SerializedName("Name")
    @Expose
    var name: String? = null,
    @SerializedName("Description")
    @Expose
    var description: Any? = null,
    @SerializedName("BranchType")
    @Expose
    var branchType: String? = null,
    @SerializedName("DeliveryStatus")
    @Expose
    var deliveryStatus: String? = null,
    @SerializedName("Circle")
    @Expose
    var circle: String? = null,
    @SerializedName("District")
    @Expose
    var district: String? = null,
    @SerializedName("Division")
    @Expose
    var division: String? = null,
    @SerializedName("Region")
    @Expose
    var region: String? = null,
    @SerializedName("Block")
    @Expose
    var block: String? = null,
    @SerializedName("State")
    @Expose
    var state: String? = null,
    @SerializedName("Country")
    @Expose
    var country: String? = null,
    @SerializedName("Pincode")
    @Expose
    var pincode: String? = null
)