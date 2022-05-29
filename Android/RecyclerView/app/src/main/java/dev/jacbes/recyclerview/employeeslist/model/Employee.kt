package dev.jacbes.recyclerview.employeeslist.model

data class Employee(
    val id: Long,
    val fullName: String,
    val photoUrl: String,
    val department: String,
    val isFavorite: Boolean
)
