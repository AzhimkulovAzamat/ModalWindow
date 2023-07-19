package net.breez.modalscreens.alert

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.alert.alternative.AlternativeDialogBuilder

/**
 * Created by azamat on 25/4/23.
 */

interface BaseDialogBuilderContract {

    var dismiss: () -> Unit
    fun setTitle(@StringRes title: Int): BaseDialogBuilderContract
    fun setTitle(title: String): BaseDialogBuilderContract

    fun setMessage(@StringRes message: Int): BaseDialogBuilderContract
    fun setMessage(message: String): BaseDialogBuilderContract
    fun setCancelable(cancelable: Boolean): BaseDialogBuilderContract
    fun setBackground(@DrawableRes resourceId: Int): BaseDialogBuilderContract
    fun create(context: Context): AlertDialog
}