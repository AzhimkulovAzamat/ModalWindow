package net.breez.modalscreens.alert.notification

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.alert.DialogBuilder

/**
 * Created by azamat on 9/8/23.
 */

interface NotificationDialogBuilder: DialogBuilder {

    fun setIcon(@DrawableRes iconRes: Int): NotificationDialogBuilder

    fun setTitle(@StringRes title: Int): NotificationDialogBuilder
    fun setTitle(title: String): NotificationDialogBuilder

    fun setMessage(@StringRes message: Int): NotificationDialogBuilder
    fun setMessage(message: String): NotificationDialogBuilder

    fun setPositiveButtonTitle(@StringRes title: Int): NotificationDialogBuilder
    fun setPositiveButtonTitle(title: String): NotificationDialogBuilder

    fun setCancelable(isCancelable: Boolean): NotificationDialogBuilder
}