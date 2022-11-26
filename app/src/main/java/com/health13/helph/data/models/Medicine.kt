package com.health13.helph.data.models

data class Medicine(
    val id:Int,
    val name: String,
    val price: Double,
    val image: String,
    val stock: Int,
    val description: String
)



val medicines = listOf<Medicine>(
    Medicine(
        1,
        "Paracetamol",
        34.3,
        "",
        234,
        "This is a pain killer"
    ),
    Medicine(
        1,
        "Doliphrane",
        12.3,
        "",
        24,
        "This is a pain killer"
    ),
    Medicine(
        1,
        "Mahloox",
        7.23,
        "",
        234,
        "This is a pain killer"
    ),
    Medicine(
        1,
        "Efferagane",
        4.12,
        "",
        234,
        "This is a pain killer"
    ),
    Medicine(
        1,
        "Cold Caps",
        2.3,
        "",
        234,
        "This is a pain killer"
    )
)