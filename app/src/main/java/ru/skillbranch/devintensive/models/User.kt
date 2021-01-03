package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id:String,
    val firstName:String?,
    val lastName:String?,
    val avatar:String?,
    val rating:Int = 0,
    val respect:Int = 0,
    var lastVisit: Date? = null,
    val isOnline: Boolean = false
) {

    constructor(id:String, firstName:String?, lastName:String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this (id, "Иван", "Петров $id")

    init {
        println("Я живой :) \n $firstName $lastName")
    }

    companion object Factory {
       private var lastId = -1
        fun makeUser(fullName:String?) :User {
            lastId++

            val (firstName, lastName)  = Utils.parseFullName(fullName = fullName)

                return User(id = "$lastId", firstName, lastName)
        }

    }

    fun printMe():Unit{
        println("""
            id: $id,
            firstName: $firstName,
            lastName: $lastName,
            avatar: $avatar,
            rating: $rating,
            respect: $respect,
            lastVisit: $lastVisit,
            isOnline: $isOnline ${"\n"}                
        """.trimIndent())

    }

}