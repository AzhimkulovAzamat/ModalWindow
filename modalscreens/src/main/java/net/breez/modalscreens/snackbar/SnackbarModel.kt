package net.breez.modalscreens.snackbar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 1/8/23.
 */

data class SnackbarModel(
    val message: StringOrResource,
    @DrawableRes
    val background: Int,
    @DrawableRes
    val icon: Int?,
    val duration: Int?
) {
    constructor(
        message: String,
        @DrawableRes
        background: Int,
        icon: Int,
        duration: Int
    ) : this(message.toSOR(), background, icon, duration)

    constructor(
        @StringRes messageId: Int,
        @DrawableRes
        background: Int,
        icon: Int,
        duration: Int
    ) : this(
        messageId.toSOR(),
        background,
        icon,
        duration,
    )
}
