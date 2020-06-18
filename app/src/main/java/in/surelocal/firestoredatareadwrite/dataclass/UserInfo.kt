package `in`.surelocal.firestoredatareadwrite.dataclass

import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("name")
    val name: String = "",

    @SerializedName("email")
    val email: String = "",

    @SerializedName("address")
    val address: String = "",

    @SerializedName("mobile")
    val mobile: String = ""
)