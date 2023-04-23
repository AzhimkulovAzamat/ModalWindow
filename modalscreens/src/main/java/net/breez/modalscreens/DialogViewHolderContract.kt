package net.breez.modalscreens

import android.content.Context
import android.view.View
import androidx.annotation.DrawableRes

/**
 * Created by azamat on 22/4/23.
 */

interface DialogViewHolderContract : CustomViewHolderDelegate {
    fun initializeView(context: Context): DialogViewHolderContract
    fun setupIcon(@DrawableRes drawableId: Int): DialogViewHolderContract
    fun setupTitle(value: String): DialogViewHolderContract
    fun setupMessage(value: String): DialogViewHolderContract
    fun setupPositiveButton(value: String, onClicked: () -> Unit): DialogViewHolderContract
    fun setupNegativeButton(value: String, onClicked: () -> Unit): DialogViewHolderContract
    fun getDialogView(): View
    fun setBackground(@DrawableRes backgroundId: Int)
}