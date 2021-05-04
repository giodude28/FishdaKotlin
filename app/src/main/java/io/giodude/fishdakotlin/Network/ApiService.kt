package io.giodude.fishdakotlin.Network

import io.giodude.fishdakotlin.Model.BonusModel
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.Model.TipsModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    //    private val ITEM_URL ="http://45.66.164.9:2294/api/"
    private val apiService: FishApi
    private val bonusAPI: FishApi
    private val tipsAPI: FishApi
    init {
        apiService = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:7566/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FishApi::class.java)

        bonusAPI = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:7565/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FishApi::class.java)

        tipsAPI = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:2294/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(FishApi::class.java)
    }

    fun getItem(): Single<List<ItemModel>>{
        return apiService.getItem()
    }

    fun getBonus(): Single<List<BonusModel>>{
        return bonusAPI.getBonus()
    }

    fun getTips(): Single<List<TipsModel>> {
        return tipsAPI.getTips()
    }

}