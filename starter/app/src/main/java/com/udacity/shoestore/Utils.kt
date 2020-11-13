package com.udacity.shoestore

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import java.lang.NumberFormatException

class Utils {
    @BindingAdapter("android:text")
    fun setDouble(editText: EditText, double: Double) {
        val string = double.toString()
        if (double.isNaN()) editText.setText(string)
        else editText.setText(string)
    }

    @InverseBindingAdapter(attribute = "android:text")
    fun getFloat(editText: EditText): Double {
        val num = editText.text.toString()
        if (num.isBlank()) return 0.0
        return try {
            num.toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }
}