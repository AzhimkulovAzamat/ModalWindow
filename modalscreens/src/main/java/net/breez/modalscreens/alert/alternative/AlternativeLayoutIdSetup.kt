package net.breez.modalscreens.alert.alternative

import net.breez.modalscreens.R

/**
 * Created by azamat on 1/6/23.
 */

interface AlternativeLayoutIdSetup {
    var iconViewId: Int
        get() = R.id.imageView_icon
        set(value) {}

    var titleViewId: Int
        get() = R.id.textView_title
        set(value) {}

    var messageViewId: Int
        get() = R.id.textView_message
        set(value) {}

    var positiveButtonId: Int
        get() = R.id.positiveButton
        set(value) {}

    var negativeButtonId: Int
        get() = R.id.negativeButton
        set(value) {}
}