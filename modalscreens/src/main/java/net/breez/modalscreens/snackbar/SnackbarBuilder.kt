package net.breez.modalscreens.snackbar

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.IntRange
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.Margins

/**
 * Created by azamat on 9/8/23.
 */

interface SnackbarBuilder {
    fun setBackground(@DrawableRes resourceId: Int): SnackbarBuilder
    fun setLength(@IntRange(from = -2, to = 0) length: Int): SnackbarBuilder
    fun setGravity(gravity: Int): SnackbarBuilder
    fun setMargins(margin: Margins): SnackbarBuilder
    fun create(container: View): Snackbar
}