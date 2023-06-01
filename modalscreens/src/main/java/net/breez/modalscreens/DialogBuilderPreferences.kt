package net.breez.modalscreens

import androidx.annotation.LayoutRes
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
    var notificationViewHolder: DialogViewHolderContract = BreezDialogViewHolder(
        DialogType.NOTIFICATION, notificationViewHolderDelegate
    )
    var alternativeViewHolder: DialogViewHolderContract = BreezDialogViewHolder(
        DialogType.ALTERNATIVE, alternativeViewHolderDelegate
    )
    var options = mutableMapOf<Int, DialogModel>()
}