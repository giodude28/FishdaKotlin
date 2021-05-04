package io.giodude.fishdakotlin.Model

import com.google.gson.annotations.SerializedName

data class TipsModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("game_name")
    val gameName: String?,
    @SerializedName("game_menu")
    val gameMenu: String?,
    @SerializedName("subtitle")
    val subtitle: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("image")
    val image: String?
)
