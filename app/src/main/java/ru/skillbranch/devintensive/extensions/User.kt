package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView():UserView{

    val nickname = Utils.transliteration("$firstName $lastName")
    val initial = Utils.toInitials(firstName, lastName)
    val status = if (lastVisit == null) "Никогда не заходил" else if (isOnline) "online" else "Последний раз был ${lastVisit?.hummanizeDiff()}"

    return UserView(id,
        fullName = "$firstName $lastName",
        nickName = nickname,
        initials = initial,
        avatar = avatar,
        status = status)
}


