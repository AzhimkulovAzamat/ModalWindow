package net.breez.modalscreens

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import net.breez.modalscreens.alert.alternative.AlternativeDialogViewHolder
import net.breez.modalscreens.alert.notification.NotificationDialogViewHolder
import net.breez.modalscreens.model.DialogModel

/**
 * Created by azamat on 23/12/22.
 */

object DialogBuilderPreferences {

    @LayoutRes
    var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout
    @LayoutRes
    var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout
    @DrawableRes
    internal var backgroundId: Int = R.drawable.default_dialog_bakground

    var options = mutableMapOf<Int, DialogModel>()
}