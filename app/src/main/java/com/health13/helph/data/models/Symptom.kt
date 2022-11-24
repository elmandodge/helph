package com.health13.helph.data.models

class Symptom {

 data class Symptom(
     val id: Int,
     val name: String
 )


    companion object{
        fun getSymptoms(): List<Symptom>{
            return listOf(
                Symptom(1, "Fever"),
                Symptom(2, "Dry Cough"),
                Symptom(2, "Headache"),
                Symptom(2, "Runny Nostrils"),
                Symptom(2, "Back pain"),
                Symptom(2, "Malaria")
            )
        }
    }


}