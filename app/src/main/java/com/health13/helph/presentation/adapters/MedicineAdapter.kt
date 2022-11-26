package com.health13.helph.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.health13.helph.R
import com.health13.helph.data.models.Medicine

class MedicineAdapter(private  val medicines: List<Medicine>): RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medicine_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(medicines[position])
    }

    override fun getItemCount() = medicines.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val image:ImageView = itemView.findViewById(R.id.medicineImage)
        val name: TextView = itemView.findViewById(R.id.medicineName)
        val price: TextView = itemView.findViewById(R.id.medicinePrice)

        fun bind(medicine: Medicine){
            name.text =  medicine.name
            price.text = "${medicine.price.toString()} USD"
        }

    }
}