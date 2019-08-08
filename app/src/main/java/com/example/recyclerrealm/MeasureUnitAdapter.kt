package com.example.recyclerrealm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults

class MeasureUnitAdapter(
    private val context: Context,
    measureUnitList: RealmResults<MeasureUnit>,
    autoUpdate: Boolean
) :
    RealmRecyclerViewAdapter<MeasureUnit, MeasureUnitAdapter.Holder>(measureUnitList, autoUpdate) {
    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val unitBold = itemView.findViewById<TextView>(R.id.txt_measureUnit_bold)
        private val unitSoft = itemView.findViewById<TextView>(R.id.txt_measureUnit_soft)
        private val unitCheckBox = itemView.findViewById<CheckBox>(R.id.checkBox_lifeTool_Item)

        fun bind(unit: MeasureUnit) {
            unitBold?.text = unit.unitNameBold
            unitSoft?.text = unit.unitNameSoft
            unitCheckBox.isChecked = false
        }

        fun checkBox() {
            unitCheckBox.setOnClickListener {
                if (unitCheckBox.isChecked) {
                    checkLong = data!![adapterPosition].unitId
                    checkList.add(checkLong)
                } else {
                    notCheckLong = data!![adapterPosition].unitId
                    if (notCheckLong in checkList) {
                        checkList.remove(notCheckLong)
                    }
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_main_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data!![position])
        holder.checkBox()
    }

    override fun getItemCount(): Int {
        return if (data == null) 0 else data!!.size
    }
}