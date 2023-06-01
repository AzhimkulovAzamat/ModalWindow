package net.breez.modalscreens

import androidx.annotation.LayoutRes
import net.breez.modalscreens.alert.alternative.AlternativeDialogViewHolder
import net.breez.modalscreens.alert.notification.NotificationDialogViewHolder
import net.breez.modalscreens.model.DialogModel
import net.breez.modalscreens.model.DialogType

/**
 * Created by azamat on 23/12/22.
 */

object DialogBuilderPreferences {

    @LayoutRes
    var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout
    @LayoutRes
    var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout
    var notificationViewHolderDelegate: CustomViewHolderDelegate = Simple()
    var alternativeViewHolderDelegate: CustomViewHolderDelegate = Simple()
    var notificationViewHolder: NotificationDialogViewHolderContract = NotificationDialogViewHolder(notificationViewHolderDelegate)
    var alternativeViewHolder: AlternativeDialogViewHolderContract = AlternativeDialogViewHolder(alternativeViewHolderDelegate)
    var options = mutableMapOf<Int, DialogModel>()
}