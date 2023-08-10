package net.breez.modalscreens.alert.alternative

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by azamat on 9/8/23.
 */

interface AlternativeDialogBuilder {

    fun setIcon(@DrawableRes iconRes: Int): AlternativeDialogBuilder

    fun setTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setTitle(title: String): AlternativeDialogBuilder

    fun setMessage(@StringRes message: Int): AlternativeDialogBuilder
    fun setMessage(message: String): AlternativeDialogBuilder

    fun setPositiveButtonTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setPositiveButtonTitle(title: String): AlternativeDialogBuilder

    fun setNegativeButtonTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setNegativeButtonTitle(title: String): AlternativeDialogBuilder

    fun setCancelable(isCancelable: Boolean): AlternativeDialogBuilder
}