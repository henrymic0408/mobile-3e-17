package com.example.retrofitexample.utils

import android.view.View
import com.example.retrofitexample.R
import com.google.android.material.snackbar.Snackbar

object SnackbarHelper {
    fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }
}