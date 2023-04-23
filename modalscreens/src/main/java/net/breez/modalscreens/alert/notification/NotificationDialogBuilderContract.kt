package net.breez.modalscreens.alert.notification

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener

/**
 * Created by azamat on 22/4/23.
 */

interface NotificationDialogBuilderContract {
    fun setIcon(@DrawableRes drawableId: Int): NotificationDialogBuilderContract

    fun setTitle(@StringRes title: Int): NotificationDialogBuilderContract
    fun setTitle(title: String): NotificationDialogBuilderContract

    fun setMessage(@StringRes message: Int): NotificationDialogBuilderContract
    fun setMessage(message: String): NotificationDialogBuilderContract

    fun setConfirmButtonTitle(@StringRes title: Int): NotificationDialogBuilderContract
    fun setConfirmButtonTitle(title: String): NotificationDialogBuilderContract

    fun setConfirmButtonClickedListener(onClicked: OnClickedListener): NotificationDialogBuilderContract

    fun setCancelable(cancelable:Boolean): NotificationDialogBuilderContract
    fun setView(@IdRes viewId:Int, customViewSetter: CustomViewSetter): NotificationDialogBuilderContract
    fun fromOptions(@StringRes messageId: Int): NotificationDialogBuilderContract

    fun create(context: Context): AlertDialog
}