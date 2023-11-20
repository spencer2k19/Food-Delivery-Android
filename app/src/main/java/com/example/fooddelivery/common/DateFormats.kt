package com.example.fooddelivery.common

import java.text.SimpleDateFormat
import java.util.Locale

val humanDateFormatWithoutDate = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
val humanDateFormat = SimpleDateFormat("E d MMMM yyyy",Locale.ENGLISH)
val yyyyMMddFormat = SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH)
val yyyyMMddFormat2 = SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH)
val ddMMyyyyFormat = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
val ddMMyyyyHHmmssFormat = SimpleDateFormat("dd/MM/yyyy HH:mm",Locale.ENGLISH)
val HHmmFormat = SimpleDateFormat("HH:mm",Locale.ENGLISH)
val yyyyMMddHHmmssFormat = SimpleDateFormat("yyyy-MM-dd HH:mm",Locale.ENGLISH)
val dayDateMonthFormat = SimpleDateFormat("dd MMM HH:mm",Locale.ENGLISH)