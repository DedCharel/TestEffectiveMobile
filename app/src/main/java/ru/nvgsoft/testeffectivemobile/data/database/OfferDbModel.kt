package ru.nvgsoft.testeffectivemobile.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offer")
data class OfferDbModel(
    @PrimaryKey val id: String,
    val title: String,
    val link: String,
    val buttonText: String?
)


