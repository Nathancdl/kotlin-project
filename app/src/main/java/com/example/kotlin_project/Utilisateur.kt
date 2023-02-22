package com.example.kotlin_project

data class Utilisateur(
    val datedenaissance: String,
    val description: String,
    val email: String,
    val genre: String,
    val publication: publication,
    val username: String,
    val uuid: String
)


data class publication(
    val content: String,
    val date: String,
    val like: String
)