package io.giodude.fishdakotlin.View

import android.content.Context
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
import io.giodude.fishdakotlin.Adapter.ItemAdapter
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.R
import io.giodude.fishdakotlin.ViewModel.ViewModels

class ItemView : Fragment() {

    lateinit var viewModel: ViewModels
    lateinit var rvItem: RecyclerView
    var iData = ArrayList<ItemModel>()
    var rviData = ArrayList<ItemModel>()
    private var arrayList: ArrayList<ItemModel>? = null
    var itemAdapter = context?.let { ItemAdapter(it, arrayListOf()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview = inflater.inflate(R.layout.activity_item_view, container, false)
        rvItem = rootview.findViewById(R.id.itemRecyclerview)
        viewModel = ViewModelProvider(activity as FragmentActivity).get(ViewModels::class.java)
        viewModel.itemData()
        iData.clear()
        rvItem.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        itemViewModel()

        return rootview
    }

    fun itemViewModel() {

        viewModel.item.observe(this, Observer { itemdata ->
            rviData.clear()
            for (item in itemdata!!){
                rviData.add(item)
                Log.d("Data", rviData.size.toString())
            }

            arrayList = ArrayList()
            arrayList = rviData
            itemAdapter = context?.let { ItemAdapter(it, arrayList!! ) }!!
            rvItem.adapter = itemAdapter
        })

//        viewModel.homeLoadError.observe(this, Observer { isError ->
//            isError?.let {
//                Toast.makeText(context,"awdawdaw"+ isError,Toast.LENGTH_LONG).show()
//            }
//        })
    }


}