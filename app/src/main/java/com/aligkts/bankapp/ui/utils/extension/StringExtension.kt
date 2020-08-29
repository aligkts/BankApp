package com.aligkts.bankapp.ui.utils.extension

import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.Years

/**
 * Created by Ali Göktaş on 29,August,2020
 */

fun String.getAge(): Int {
    val dateOfBirth = DateTime(this)
    return Years.yearsBetween(
        LocalDate(
            dateOfBirth.year,
            dateOfBirth.monthOfYear,
            dateOfBirth.dayOfMonth
        ), LocalDate()
    ).years
}