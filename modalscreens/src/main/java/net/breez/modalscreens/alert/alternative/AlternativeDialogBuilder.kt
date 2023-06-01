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

interface AlternativeDialogBuilder : BaseDialogBuilderContract {

    fun setIcon(@DrawableRes drawableId: Int): AlternativeDialogBuilder

    override fun setTitle(title: Int): AlternativeDialogBuilder
    override fun setTitle(title: String): AlternativeDialogBuilder

    override fun setCancelable(cancelable: Boolean): AlternativeDialogBuilder

    override fun setBackground(resourceId: Int): AlternativeDialogBuilder

    fun setMessage(@StringRes message: Int): AlternativeDialogBuilder
    fun setMessage(message: String): AlternativeDialogBuilder

    fun setPositiveTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setPositiveTitle(title: String): AlternativeDialogBuilder

    fun setPositiveClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilder

    fun setNegativeTitle(@StringRes title: Int): AlternativeDialogBuilder
    fun setNegativeTitle(title: String): AlternativeDialogBuilder

    fun setNegativeClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilder

    fun setView(
        @IdRes viewId: Int,
        customViewSetter: CustomViewSetter
    ): AlternativeDialogBuilder

    fun fromOptions(@StringRes dialogId: Int): AlternativeDialogBuilder
}