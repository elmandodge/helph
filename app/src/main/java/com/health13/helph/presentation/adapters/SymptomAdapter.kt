package com.health13.helph.presentation.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.health13.helph.R
import com.health13.helph.data.models.Symptom


class SymptomAdapter(private  val symptoms: List<Symptom.Symptom>): RecyclerView.Adapter<SymptomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.symptom_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(symptoms[position])
    }

    override fun getItemCount() =symptoms.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val name: Button = itemView.findViewById(R.id.button)
        fun bind(category: Symptom.Symptom){
          name.text = category.name
        }


        private fun getEmojiByUnicode(unicode: Int): String {
            return String(Character.toChars(unicode))
        }
    }
}