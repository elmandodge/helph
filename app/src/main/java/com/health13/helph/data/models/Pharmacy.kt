package com.health13.helph.data.models

data class Pharmacy(
    val id: Int,
    val name : String,
    val town: String,
    val image: String,
    val country: String,
    val phone: Long,
    val latitude: Double,
    val longitude: Double,
    val rating: Double,
    val medicines: List<Medicine>

)


val pharmacies: List<Pharmacy> = listOf(
    Pharmacy(
        1,
        "Grace Pharmacy",
        "Yaounde",
        "pharm1",
        "Cameroon",
        676521915,
        12.32332,
        3.434234,
        4.5,
        medicines
    ),
    Pharmacy(
        1,
        "Med's Pharmacy",
        "Bafoussam",
        "pharm1",
        "Cameroon",
        676521915,
        12.32332,
        3.434234,
        4.5,
        medicines
    ),
    Pharmacy(
        1,
        "Post Pharmacy",
        "Douala",
        "pharm1",
        "Cameroon",
        676521915,
        12.32332,
        3.434234,
        4.5,
        medicines
    )
)


