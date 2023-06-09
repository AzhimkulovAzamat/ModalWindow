package net.breez.modalscreens

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes

/**
 * Created by azamat on 22/4/23.
 */

interface BaseDialogViewHolderContract {
    fun initializeView(context: Context): BaseDialogViewHolderContract
    fun setupIcon(@DrawableRes drawableId: Int): BaseDialogViewHolderContract
    fun setupTitle(value: String): BaseDialogViewHolderContract
    fun setupMessage(value: String): BaseDialogViewHolderContract
    fun getDialogView(): View
    fun setBackground(@DrawableRes backgroundId: Int): BaseDialogViewHolderContract
}

interface AlternativeDialogViewHolderContract : BaseDialogViewHolderContract {
    fun setupPositiveButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract

    fun setupNegativeButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract
}

interface NotificationDialogViewHolderContract : BaseDialogViewHolderContract {

    var submitButtonId: Int

    fun setupSubmitButton(
        value: String,
        onClicked: () -> Unit
    ): NotificationDialogViewHolderContract
}