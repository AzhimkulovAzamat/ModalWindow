package net.breez.modalscreens.alert

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface SimpleDialogBuilder: DialogBuilder {

    fun setIcon(@DrawableRes iconRes: Int): SimpleDialogBuilder

    fun setTitle(@StringRes titleRes: Int): SimpleDialogBuilder
    fun setTitle(title: String): SimpleDialogBuilder

    fun setMessage(@StringRes messageRes: Int): SimpleDialogBuilder
    fun setMessage(message: String): SimpleDialogBuilder

    fun setPositiveButton(@StringRes titleRes: Int, action: (View) -> Boolean): SimpleDialogBuilder
    fun setPositiveButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder

    fun setNegativeButton(@StringRes titleInt: Int, action: (View) -> Boolean): SimpleDialogBuilder
    fun setNegativeButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder

//    fun setNeutralButton(@StringRes titleRes: Int, action: (View) -> Boolean): SimpleDialogBuilder
//    fun setNeutralButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder

    fun setCancelable(isCancelable: Boolean): SimpleDialogBuilder
}