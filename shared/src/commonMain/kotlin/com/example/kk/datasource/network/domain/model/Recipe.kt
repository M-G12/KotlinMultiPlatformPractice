package com.example.kk.domain.model

import kotlinx.datetime.LocalDateTime

data class Recipe(
    val id:Int,
    val title:String,
    val publisher:String,
    val featureImage:String,
    val rating:Int,
    val sourceUrl:String,
    val ingredients: List<String>,
    val dateAdded: LocalDateTime,
    val dateUpdated: LocalDateTime,
)
