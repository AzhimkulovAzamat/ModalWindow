package net.breez.modalscreens.alert.alternative

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener

/**
 * Created by azamat on 23/4/23.
 */

interface AlternativeDialogBuilderContract {
    fun setIcon(@DrawableRes drawableId: Int): AlternativeDialogBuilderContract

    fun setTitle(@StringRes title: Int): AlternativeDialogBuilderContract
    fun setTitle(title: String): AlternativeDialogBuilderContract

    fun setMessage(@StringRes message: Int): AlternativeDialogBuilderContract
    fun setMessage(message: String): AlternativeDialogBuilderContract

    fun setPositiveButtonTitle(@StringRes title: Int): AlternativeDialogBuilderContract
    fun setPositiveButtonTitle(title: String): AlternativeDialogBuilderContract

    fun setPositiveButtonClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderContract

    fun setNegativeTitle(@StringRes title: Int): AlternativeDialogBuilderContract
    fun setNegativeTitle(title: String): AlternativeDialogBuilderContract

    fun setNegativeClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderContract

    fun setCancelable(cancelable:Boolean): AlternativeDialogBuilderContract
    fun setView(@IdRes viewId:Int, customViewSetter: CustomViewSetter): AlternativeDialogBuilderContract
    fun fromOptions(@StringRes messageId: Int): AlternativeDialogBuilderContract

    fun create(context: Context): AlertDialog
}