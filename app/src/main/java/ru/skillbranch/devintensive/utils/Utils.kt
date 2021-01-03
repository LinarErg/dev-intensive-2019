package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?): Pair<String?, String?>{

        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        val firstNameString = if (firstName == null || firstName.isBlank()) "null" else firstName
        val lastNameString = if (lastName == null || lastName.isBlank()) "null" else lastName

        return firstNameString to lastNameString
    }

    fun transliteration(payload: String, divider:String = " "): String {
        return ""
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        return ""
    }

}