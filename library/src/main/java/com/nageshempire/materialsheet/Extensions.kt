package com.nageshempire.materialsheet

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment

fun AppCompatActivity.showDialog(dialogFragment: DialogFragment, tag: String? = null) {
    dialogFragment.showNow(supportFragmentManager, tag)
}

fun Fragment.showDialog(dialogFragment: DialogFragment, tag: String? = null) {
    dialogFragment.showNow(parentFragmentManager, tag)
}