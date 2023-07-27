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

    fun setSubmitTitle(@StringRes title: Int): RadioDialogBuilder
    fun setSubmitTitle(title: String): RadioDialogBuilder

    fun setSubmitClickedListener(onClicked: OnClickedListener): RadioDialogBuilder

    fun setCancelTitle(@StringRes title: Int): RadioDialogBuilder
    fun setCancelTitle(title: String): RadioDialogBuilder

    fun setCancelClickedListener(onClicked: OnClickedListener): RadioDialogBuilder

    fun fromOptions(@StringRes dialogId: Int): RadioDialogBuilder
    fun setInteraction(value: RadioDialogBuilderImpl.RecyclerAdapterInteraction): RadioDialogBuilder
}