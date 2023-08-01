package net.breez.modalscreens.snackbar

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import androidx.annotation.LayoutRes
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.StringOrResource

/**
 * Created by azamat on 28/7/23.
 */

interface SnackbarNotificationBuilder {
    fun setViewHolder(holder: SnackbarViewHolder): SnackbarNotificationBuilder
    fun setView(
        @LayoutRes layoutId: Int,
        customViewSetter: CustomViewSetter
    ): SnackbarNotificationBuilder

    fun setDuration(
        @IntRange(
            from = -2,
            to = 0
        ) duration: Int
    ): SnackbarNotificationBuilder

    fun setPadding(left: Int, top: Int, right: Int, bottom: Int): SnackbarNotificationBuilder
    fun setGravity(gravity: Int): SnackbarNotificationBuilder

    fun fromOptions(optionsId: Int): SnackbarNotificationBuilder
    fun create(container: View): Snackbar
    var dismiss: () -> Unit
}