package com.messir.REminder.ui.utils.converters

import java.text.SimpleDateFormat
import java.util.*

fun Date.dateToString(format: String): String {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())

    return dateFormatter.format(this)
}