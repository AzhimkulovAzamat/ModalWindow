package net.breez.modalscreens.alert.notification

import net.breez.modalscreens.R

/**
 * Created by azamat on 1/6/23.
 */

interface NotificationLayoutIdSetup {
    var iconViewId: Int
        get() = R.id.imageView_icon
        set(value) {}
    var titleViewId: Int
        get() = R.id.textView_title
        set(value) {}
    var messageViewId: Int
        get() = R.id.textView_message
        set(value) {}
    var submitButtonId: Int
        get() = R.id.positiveButton
        set(value) {}
}