package io.giodude.fishdakotlin.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.giodude.fishdakotlin.Model.BonusModel
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.Model.TipsModel
import io.giodude.fishdakotlin.Network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

class ViewModels: ViewModel() {

    private val TAG = "ViewModel"
    private val apiService = ApiService()
    private val disposable = CompositeDisposable()

    val itemData = MutableLiveData<List<ItemModel>>()
    val bonusData = MutableLiveData<List<BonusModel>>()
    val tipsData = MutableLiveData<List<TipsModel>>()
    val homeLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    val item : LiveData<List<ItemModel>> get() = itemData
    val bonus : LiveData<List<BonusModel>> get() = bonusData
    val tips : LiveData<List<TipsModel>> get() = tipsData
    fun itemData(){
        getItem()
    }
    fun bonusData(){
        getBonus()
    }

    fun tipsData(){
      getTips()
    }
    private fun getItem(){
        disposable.add(
            apiService.getItem()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ItemModel>>() {
                    override fun onSuccess(value: List<ItemModel>?) {
                        itemData.value = value!!
                        homeLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        homeLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }

    private fun getBonus(){
        disposable.add(
            apiService.getBonus()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<BonusModel>>() {
                    override fun onSuccess(value: List<BonusModel>?) {
                        bonusData.value = value!!
                        homeLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        homeLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }
    private fun getTips(){
        disposable.add(
            apiService.getTips()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<TipsModel>>() {
                    override fun onSuccess(value: List<TipsModel>?) {
                        val list = ArrayList(value?.filter { it.gameName=="Bắn cá 2021" })

                        tipsData.value = list
                        homeLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable?) {
                        homeLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }
//   private fun getTips() {
//        apiService.getTips()
//            .flatMap(Observable::fromIterable)
//            .filter { result -> result.gameName.equals("Bắn cá 2021") }
//            .toList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ result -> tipsData.setValue(result) }
//            ) { error -> Log.e(TAG, "getTips: " + tipsData.toString()) }
//    }

}