package net.breez.modalscreens

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import net.breez.modalscreens.alert.alternative.AlternativeLayoutIdSetup
import net.breez.modalscreens.alert.notification.NotificationLayoutIdSetup
import net.breez.modalscreens.alert.radio.RadioLayoutIdSetup
import net.breez.modalscreens.model.DialogModel

/**
 * Created by azamat on 23/12/22.
 */

object DialogBuilderPreferences {

    @LayoutRes
    var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout
    @LayoutRes
    var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout
    @LayoutRes
    var radioLayoutId: Int = R.layout.breez_radio_dialog_layout
    @DrawableRes
    internal var backgroundId: Int = R.drawable.default_dialog_bakground

    var defaultNotificationLayoutIds = object : NotificationLayoutIdSetup {
        override var iconViewId = R.id.imageView_icon
        override var titleViewId = R.id.textView_title
        override var messageViewId = R.id.textView_message
        override var submitButtonId: Int = R.id.positiveButton
    }

    var defaultAlternativeLayoutIds = object : AlternativeLayoutIdSetup {
        override var iconViewId = R.id.imageView_icon
        override var titleViewId = R.id.textView_title
        override var messageViewId = R.id.textView_message
        override var positiveButtonId = R.id.positiveButton
        override var negativeButtonId = R.id.negativeButton
    }

    var defaultRadioLayoutIds = object : RadioLayoutIdSetup {
        override var iconViewId = R.id.imageView_icon
        override var titleViewId = R.id.textView_title
        override var messageViewId = R.id.textView_message
        override var positiveButtonId = R.id.positiveButton
        override var negativeButtonId = R.id.negativeButton
    }

    var options = mutableMapOf<Int, DialogModel>()
}