package io.giodude.fishdakotlin.Network

import io.giodude.fishdakotlin.Model.BonusModel
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.Model.TipsModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface FishApi {

    @GET("shootingfishweapons")
    fun getItem(): Single<List<ItemModel>>

    @GET("shootingfishbonusesandicon")
    fun getBonus(): Single<List<BonusModel>>

    @GET("shootingfishtips")
    fun getTips(): Single<List<TipsModel>>
}