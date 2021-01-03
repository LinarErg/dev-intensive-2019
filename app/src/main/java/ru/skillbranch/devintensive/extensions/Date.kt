package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"):String{
    val  dateFormat = SimpleDateFormat(pattern,Locale("ru"))
    return  dateFormat.format(this)
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND):Date{
    this.time += value * units.value
    return this
}

fun Date.hummanizeDiff(date: Date = Date()): String {

    val timeDiff =   date.time - this.time

    val s = when (timeDiff) {
        in 0..(TimeUnits.SECOND.value * 2 -1) -> "только что"
        in TimeUnits.SECOND.value..(TimeUnits.SECOND.value * 45 + TimeUnits.SECOND.value) -> "несколько секунд назад"
        in (TimeUnits.SECOND.value * 45)..(TimeUnits.SECOND.value * 75 + TimeUnits.SECOND.value) -> "минуту назад"
        in (TimeUnits.SECOND.value * 75)..(TimeUnits.MINUTE.value * 45 + TimeUnits.SECOND.value) -> "N минут назад"
        in (TimeUnits.MINUTE.value * 45)..(TimeUnits.MINUTE.value * 75 + TimeUnits.SECOND.value) -> "час назад"
        in (TimeUnits.MINUTE.value * 75)..(TimeUnits.HOUR.value * 22 + TimeUnits.SECOND.value) -> "N часов назад"
        in (TimeUnits.HOUR.value * 22)..(TimeUnits.HOUR.value * 26 + TimeUnits.SECOND.value) -> "день назад"
        in (TimeUnits.HOUR.value * 26)..(TimeUnits.DAY.value * 360 + TimeUnits.SECOND.value) -> "N дней назад"
        else -> "более года назад"}
    return s

}

enum class TimeUnits(val value:Long){
    SECOND(1000L),
    MINUTE(60 * SECOND.value),
    HOUR(60 * MINUTE.value),
    DAY(24 * HOUR.value);

}