package io.giodude.fishdakotlin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.giodude.fishdakotlin.Adapter.BonusAdapter
import io.giodude.fishdakotlin.Model.BonusModel
import io.giodude.fishdakotlin.R
import io.giodude.fishdakotlin.ViewModel.ViewModels

class BonusView : Fragment() {

    lateinit var viewModel: ViewModels
    lateinit var  rvBonus: RecyclerView
    var bData = ArrayList<BonusModel>()
    var rvbData = ArrayList<BonusModel>()
    private var arrayList: ArrayList<BonusModel>? = null
    var bonusAdapter = context?.let { BonusAdapter(it, arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.activity_bonus_view, container, false)
        rvBonus = rootview.findViewById(R.id.bonusRecyclerview)

        viewModel = ViewModelProvider(activity as FragmentActivity).get(ViewModels::class.java)
        viewModel.bonusData()
      //  bData.clear()
        rvBonus.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        bonusViewModel()
        return rootview
    }

    fun bonusViewModel(){

        viewModel.bonus.observe(this, Observer { bonusdata ->
            rvbData.clear()
            for (item in bonusdata!!){
                rvbData.add(item)
                Log.d("Data", rvbData.size.toString())
            }

            arrayList = ArrayList()
            arrayList = rvbData
            bonusAdapter = context?.let { BonusAdapter(it, arrayList!!) }!!
            rvBonus.adapter = bonusAdapter

        })

//        viewModel.homeLoadError.observe(this, Observer { isError ->
//            isError?.let {
//                Toast.makeText(context,"awdawdawd"+isError, Toast.LENGTH_LONG).show()
//            }
//        })
    }
}