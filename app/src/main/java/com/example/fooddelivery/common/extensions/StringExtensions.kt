package com.example.fooddelivery.common.extensions


import com.example.fooddelivery.common.HHmmFormat
import com.example.fooddelivery.common.dayDateMonthFormat
import com.example.fooddelivery.common.ddMMyyyyFormat
import com.example.fooddelivery.common.ddMMyyyyHHmmssFormat
import com.example.fooddelivery.common.humanDateFormat
import com.example.fooddelivery.common.humanDateFormatWithoutDate
import com.example.fooddelivery.common.yyyyMMddFormat
import com.example.fooddelivery.common.yyyyMMddHHmmssFormat
import java.text.SimpleDateFormat
import java.util.*


fun String.toHumanMonthFromDate(): String {
    //current date is for example 02/07/2022 and we want as result -> 02 Aout 2022
    val data = this.split('/')
    val month = data[1].toInt()
    val cal: Calendar = Calendar.getInstance()
    val monthDate = SimpleDateFormat("MMMM")
    cal.set(Calendar.MONTH, month)
    return "${data[0]} ${monthDate.format(cal.time)} ${data[2]}"
}

fun String.toHumanDateFromTZ(): String? {
    val date = this.split('T')[0]
    return humanDateFormatWithoutDate.format(yyyyMMddFormat.parse(date))
}

fun String.toDisplayDateFromTZ(): String? {
    val date = this.split('T')[0]
    return ddMMyyyyFormat.format(yyyyMMddFormat.parse(date))
}

fun String.toDisplayDateTimeFromTZ(): String? {
    val dates = this.split('T')
    val date = dates[0]
    val time = dates[1].split("+")[0]
    val oldDate = yyyyMMddHHmmssFormat.parse("$date $time")
    return ddMMyyyyHHmmssFormat.format(oldDate)
}

fun String.toDisplayTimeFromTZ(): String? {
    val dates = this.split('T')
    val date = dates[0]
    val time = dates[1].split("+")[0]
    val oldDate = yyyyMMddHHmmssFormat.parse("$date $time")
    return HHmmFormat.format(oldDate)
}

fun String.toHumanDate(): String? {
    return humanDateFormat.format(yyyyMMddFormat.parse(this))
}

fun String.toHumanWithoutDate(): String? {
    return humanDateFormatWithoutDate.format(yyyyMMddFormat.parse(this))
}

fun String.toHumanDateFromDate(): String? {
    return humanDateFormat.format(ddMMyyyyFormat.parse(this))
}

fun String.toDateFromHumanDate(): String? {
    return ddMMyyyyFormat.format(humanDateFormatWithoutDate.parse(this))
}

fun String.toDayDateTimeFromTZ(): String? {
    val dates = this.split('T')
    val date = dates[0]
    val time = dates[1].split("+")[0]
    val oldDate = yyyyMMddHHmmssFormat.parse("$date $time")
    return dayDateMonthFormat.format(oldDate)
}

fun String.toDayDateTime(): String? {
    val dates = this.split(' ')
    val date = dates[0]
    val time = dates[1]
    val oldDate = yyyyMMddHHmmssFormat.parse("$date $time")
    return dayDateMonthFormat.format(oldDate)
}


