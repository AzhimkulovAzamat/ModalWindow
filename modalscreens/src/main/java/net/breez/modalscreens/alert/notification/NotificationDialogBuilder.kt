package net.breez.modalscreens.alert.notification

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.BaseDialogBuilderContract

/**
 * Created by azamat on 22/4/23.
 */

interface NotificationDialogBuilder : BaseDialogBuilderContract {
    fun setIcon(@DrawableRes drawableId: Int): NotificationDialogBuilder

    override fun setTitle(title: Int): NotificationDialogBuilder
    override fun setTitle(title: String): NotificationDialogBuilder

    override fun setBackground(resourceId: Int): NotificationDialogBuilder
    override fun setCancelable(cancelable: Boolean): NotificationDialogBuilder

    override fun setMessage(@StringRes message: Int): NotificationDialogBuilder
    override fun setMessage(message: String): NotificationDialogBuilder

    fun setConfirmButtonTitle(@StringRes title: Int): NotificationDialogBuilder
    fun setConfirmButtonTitle(title: String): NotificationDialogBuilder

    fun setConfirmButtonClickedListener(onClicked: OnClickedListener): NotificationDialogBuilder

    fun setView(
        @IdRes viewId: Int,
        customViewSetter: CustomViewSetter
    ): NotificationDialogBuilder

    fun fromOptions(@StringRes dialogId: Int): NotificationDialogBuilder
}