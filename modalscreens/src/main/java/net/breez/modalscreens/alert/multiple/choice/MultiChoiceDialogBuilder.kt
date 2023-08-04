package net.breez.modalscreens.alert.multiple.choice

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.BaseDialogBuilderContract

/**
 * Created by azamat on 2/8/23.
 */

interface MultiChoiceDialogBuilder : BaseDialogBuilderContract {

    override fun setTitle(title: Int): MultiChoiceDialogBuilder
    override fun setTitle(title: String): MultiChoiceDialogBuilder

    override fun setMessage(message: Int): MultiChoiceDialogBuilder
    override fun setMessage(message: String): MultiChoiceDialogBuilder

    override fun setCancelable(cancelable: Boolean): MultiChoiceDialogBuilder
    override fun setBackground(resourceId: Int): MultiChoiceDialogBuilder

    fun setSubmitTitle(@StringRes title: Int): MultiChoiceDialogBuilder
    fun setSubmitTitle(title: String): MultiChoiceDialogBuilder

    fun setSubmitClickedListener(onClicked: OnClickedListener): MultiChoiceDialogBuilder

    fun setCancelTitle(@StringRes title: Int): MultiChoiceDialogBuilder
    fun setCancelTitle(title: String): MultiChoiceDialogBuilder

    fun setCancelClickedListener(onClicked: OnClickedListener): MultiChoiceDialogBuilder

    fun fromOptions(@StringRes dialogId: Int): MultiChoiceDialogBuilder
    fun setInteraction(value: MultiChoiceDialogBuilderImpl.RecyclerAdapterInteraction): MultiChoiceDialogBuilder

    override fun create(context: Context): AlertDialog
}