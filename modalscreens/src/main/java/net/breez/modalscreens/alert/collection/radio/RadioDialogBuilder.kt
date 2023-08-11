package net.breez.modalscreens.alert.collection.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.DialogBuilder
import net.breez.modalscreens.alert.collection.BreezRadioViewHolder
import net.breez.modalscreens.alert.collection.RadioViewHolder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 10/8/23.
 */

interface RadioDialogBuilder: DialogBuilder {

    fun setIcon(@DrawableRes iconRes: Int): RadioDialogBuilder

    fun setTitle(@StringRes title: Int): RadioDialogBuilder
    fun setTitle(title: String): RadioDialogBuilder

    fun setMessage(@StringRes message: Int): RadioDialogBuilder
    fun setMessage(message: String): RadioDialogBuilder

    fun setPositiveButtonTitle(@StringRes title: Int): RadioDialogBuilder
    fun setPositiveButtonTitle(title: String): RadioDialogBuilder

    fun setNegativeButtonTitle(@StringRes title: Int): RadioDialogBuilder
    fun setNegativeButtonTitle(title: String): RadioDialogBuilder

    fun setOnPositiveClickListener(listener: OnClickedListener): RadioDialogBuilder
    fun setOnNegativeClickListener(listener: OnClickedListener): RadioDialogBuilder

    fun setCancelable(isCancelable: Boolean): RadioDialogBuilder
    fun setInteraction(value: RecyclerAdapterInteraction): RadioDialogBuilder
    
    interface RecyclerAdapterInteraction {
        fun onCreateViewHolder(parent: ViewGroup): RadioViewHolder {
            val binding = BreezRowRadioLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return BreezRadioViewHolder(binding)
        }

        fun getItemSize(): Int
        fun getModel(position: Int): Any
        fun onSelected(position: Int)
    }
}