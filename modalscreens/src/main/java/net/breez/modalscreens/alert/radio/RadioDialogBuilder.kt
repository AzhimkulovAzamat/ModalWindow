package net.breez.modalscreens.alert.radio

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.BaseDialogBuilderContract

/**
 * Created by azamat on 2/6/23.
 */

interface RadioDialogBuilder: BaseDialogBuilderContract {

    fun setIcon(@DrawableRes drawableId: Int): RadioDialogBuilder

    override fun setTitle(title: Int): RadioDialogBuilder
    override fun setTitle(title: String): RadioDialogBuilder

    override fun setCancelable(cancelable: Boolean): RadioDialogBuilder

    override fun setBackground(resourceId: Int): RadioDialogBuilder

    override fun setMessage(@StringRes message: Int): RadioDialogBuilder
    override fun setMessage(message: String): RadioDialogBuilder

    fun setPositiveTitle(@StringRes title: Int): RadioDialogBuilder
    fun setPositiveTitle(title: String): RadioDialogBuilder

    fun setPositiveClickedListener(onClicked: OnClickedListener): RadioDialogBuilder

    fun setNegativeTitle(@StringRes title: Int): RadioDialogBuilder
    fun setNegativeTitle(title: String): RadioDialogBuilder

    fun setNegativeClickedListener(onClicked: OnClickedListener): RadioDialogBuilder

    fun fromOptions(@StringRes dialogId: Int): RadioDialogBuilder
    fun setInteraction(value: RadioDialogBuilderImpl.RecyclerAdapterInteraction): RadioDialogBuilder
}