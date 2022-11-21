package com.example.sw_antonioog.start

data class StartResponser(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)