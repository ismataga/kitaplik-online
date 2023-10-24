package com.example.libraryservice.dto

data class BookDto @JvmOverloads constructor(
    val title: String? = "",
    val bookYear: Int? = 0,
    val author: String? = "",
    val pressName: String? = ""
)