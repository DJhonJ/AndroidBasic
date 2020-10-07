package com.example.androidbasic.model

import java.io.Serializable

// data class, clase para tratar datos (ej: deserializar objetos, etc...)
data class Hobby (var title: String) : Serializable

//expresion de objeto (expression object)
// funciona como un objeto de una clase

object Supplier {
    val hobbies = listOf<Hobby>(
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir"),
        Hobby("Leer"),
        Hobby("Cantar"),
        Hobby("Caminar"),
        Hobby("Dormir")
    )
}
