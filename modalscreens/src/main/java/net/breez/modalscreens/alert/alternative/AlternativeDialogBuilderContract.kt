package net.breez.modalscreens.alert.alternative

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.BaseDialogBuilderContract

/**
 * Created by azamat on 23/4/23.
 */

interface AlternativeDialogBuilderContract : BaseDialogBuilderContract {
    fun setIcon(@DrawableRes drawableId: Int): AlternativeDialogBuilderContract

    override fun setTitle(title: Int): AlternativeDialogBuilderContract
    override fun setTitle(title: String): AlternativeDialogBuilderContract

    override fun setCancelable(cancelable: Boolean): AlternativeDialogBuilderContract

    override fun setBackground(resourceId: Int): AlternativeDialogBuilderContract

    fun setMessage(@StringRes message: Int): AlternativeDialogBuilderContract
    fun setMessage(message: String): AlternativeDialogBuilderContract

    fun setPositiveButtonTitle(@StringRes title: Int): AlternativeDialogBuilderContract
    fun setPositiveButtonTitle(title: String): AlternativeDialogBuilderContract

    fun setPositiveButtonClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderContract

    fun setNegativeTitle(@StringRes title: Int): AlternativeDialogBuilderContract
    fun setNegativeTitle(title: String): AlternativeDialogBuilderContract

    fun setNegativeClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderContract

    fun setView(
        @IdRes viewId: Int,
        customViewSetter: CustomViewSetter
    ): AlternativeDialogBuilderContract

    fun fromOptions(@StringRes messageId: Int): AlternativeDialogBuilderContract
}