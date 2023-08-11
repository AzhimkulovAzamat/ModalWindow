package net.breez.modalscreens.alert.alternative

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.DialogBuilder

/**
 * Created by azamat on 9/8/23.
 */

interface AlternativeDialogBuilder: DialogBuilder {

    fun setIcon(@DrawableRes iconRes: Int): AlternativeDialogBuilder

    fun setTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setTitle(title: String): AlternativeDialogBuilder

    fun setMessage(@StringRes message: Int): AlternativeDialogBuilder
    fun setMessage(message: String): AlternativeDialogBuilder

    fun setPositiveButtonTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setPositiveButtonTitle(title: String): AlternativeDialogBuilder

    fun setNegativeButtonTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setNegativeButtonTitle(title: String): AlternativeDialogBuilder

    fun setOnPositiveClickListener(listener: OnClickedListener): AlternativeDialogBuilder
    fun setOnNegativeClickListener(listener: OnClickedListener): AlternativeDialogBuilder

    fun setCancelable(isCancelable: Boolean): AlternativeDialogBuilder
}