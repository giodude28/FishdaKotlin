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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.giodude.fishdakotlin.Adapter.BonusAdapter
import io.giodude.fishdakotlin.Adapter.ItemAdapter
import io.giodude.fishdakotlin.Adapter.TipsAdapter
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.Model.TipsModel
import io.giodude.fishdakotlin.R
import io.giodude.fishdakotlin.ViewModel.ViewModels

class TipsView : Fragment() {

    lateinit var viewModel: ViewModels
    lateinit var  rvBonus: RecyclerView
    var bData = ArrayList<TipsModel>()
    var rvbData = ArrayList<TipsModel>()
    private var arrayList: ArrayList<TipsModel>? = null
    var bonusAdapter = context?.let { TipsAdapter(it, arrayListOf()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.activity_tips_view, container, false)

        rvBonus = rootview.findViewById(R.id.tipsRecyclerview)

        viewModel = ViewModelProvider(activity as FragmentActivity).get(ViewModels::class.java)
        viewModel.tipsData()
        bData.clear()
        rvBonus.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        bonusViewModel()
        return rootview
    }

    fun bonusViewModel(){

        viewModel.tips.observe(this, Observer { bonusdata ->
            rvbData.clear()
            for (item in bonusdata!!){
                rvbData.add(item)
                Log.d("Data", rvbData.size.toString())
            }

            arrayList = ArrayList()
            arrayList = rvbData
            bonusAdapter = context?.let { TipsAdapter(it, arrayList!!) }!!
            rvBonus.adapter = bonusAdapter

        })

//        viewModel.homeLoadError.observe(this, Observer { isError ->
//            isError?.let {
//                Toast.makeText(context,"awdawdawd"+isError, Toast.LENGTH_LONG).show()
//            }
//        })
    }
}