package com.health13.helph.presentation.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.health13.helph.R
import com.health13.helph.data.models.Pharmacy
import com.health13.helph.data.models.Symptom
import com.health13.helph.presentation.activities.PharmacyDetailActivity


class PharmacyAdapter(private val pharmacies: List<Pharmacy>, private val context: Context): RecyclerView.Adapter<PharmacyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pharmacy_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pharmacies[position])
    }

    override fun getItemCount() = pharmacies.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, PharmacyDetailActivity::class.java)
                context.startActivity(intent)
            }
        }

        val image : ImageView = itemView.findViewById(R.id.pharmacyImage)
        val name: TextView = itemView.findViewById(R.id.pharmacyName)
        val location: TextView = itemView.findViewById(R.id.pharmacyLocation)
        val distance: TextView = itemView.findViewById(R.id.pharmacyDistance)
        val rating: RatingBar = itemView.findViewById(R.id.pharmacyRating)

        fun bind(pharmacy: Pharmacy){
            name.text =  pharmacy.name
            location.text = "${pharmacy.country}, ${pharmacy.town}"
            distance.text = "4.2 km (15 min)"
            rating.rating = pharmacy.rating.toFloat()
        }


    }
}