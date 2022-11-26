package com.health13.helph.presentation.activities
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.health13.helph.data.models.Pharmacy
import com.health13.helph.data.models.Symptom
import com.health13.helph.data.models.medicines
import com.health13.helph.data.models.pharmacies
import com.health13.helph.databinding.ActivityMainBinding
import com.health13.helph.presentation.adapters.MedicineAdapter
import com.health13.helph.presentation.adapters.PharmacyAdapter
import com.health13.helph.presentation.adapters.SymptomAdapter
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SymptomAdapter
    private lateinit var medicineAdapter: MedicineAdapter
    private lateinit var pharmacyAdapter: PharmacyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        adapter = SymptomAdapter(Symptom.getSymptoms())
        pharmacyAdapter = PharmacyAdapter(pharmacies, this)
        medicineAdapter = MedicineAdapter(medicines)


        binding.pharmacyList.adapter = pharmacyAdapter
        binding.pharmacyList.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        binding.medicineList.adapter = medicineAdapter
        binding.medicineList.layoutManager = GridLayoutManager(this, 2)


        binding.symptomList.adapter =  adapter
        binding.symptomList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)




    }


}