package io.giodude.fishdakotlin.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.giodude.fishdakotlin.Model.ItemModel
import io.giodude.fishdakotlin.Model.TipsModel
import io.giodude.fishdakotlin.R
import kotlinx.android.synthetic.main.details.view.*

class TipsAdapter(var context: Context, val itemList: ArrayList<TipsModel>): RecyclerView.Adapter<TipsAdapter.ItemViewHolder>(){


    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.bonusname)
        val itemDesc: TextView = itemView.findViewById(R.id.bonusdesc)
        val itemSee: TextView = itemView.findViewById(R.id.see)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bonus_item, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentUI = itemList.get(position)
        holder.itemTitle.text = currentUI.subtitle
        holder.itemDesc.text = currentUI.description

        holder.itemSee.setOnClickListener {

            val mDialogView = LayoutInflater.from(context).inflate(R.layout.details, null)

            val mBuilder = AlertDialog.Builder(context)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()

            mDialogView.title.text = currentUI.subtitle
            mDialogView.desc.text = currentUI.description
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}