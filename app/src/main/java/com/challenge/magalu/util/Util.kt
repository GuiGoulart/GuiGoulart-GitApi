package com.challenge.magalu.util

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat

object Util {

    @SuppressLint("SimpleDateFormat")
    fun convertDateFormat(date: String, initDateFormat: String, endDateFormat: String): String {
        return try {
            val initDate = SimpleDateFormat(initDateFormat).parse(date)
            val formatter = SimpleDateFormat(endDateFormat)
            formatter.format(initDate!!)
        } catch (e: ParseException) {
            e.printStackTrace()
            "Erro ao obter data"
        }
    }

}