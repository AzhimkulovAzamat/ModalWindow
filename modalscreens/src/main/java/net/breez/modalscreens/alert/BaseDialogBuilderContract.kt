package net.breez.modalscreens.alert

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by azamat on 25/4/23.
 */

interface BaseDialogBuilderContract {

    fun setTitle(@StringRes title: Int): BaseDialogBuilderContract
    fun setTitle(title: String): BaseDialogBuilderContract
    fun setCancelable(cancelable: Boolean): BaseDialogBuilderContract
    fun setBackground(@DrawableRes resourceId: Int): BaseDialogBuilderContract
}