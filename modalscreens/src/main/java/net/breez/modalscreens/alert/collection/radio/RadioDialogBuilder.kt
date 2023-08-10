package net.breez.modalscreens.alert.collection.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.alert.collection.BreezRadioViewHolder
import net.breez.modalscreens.alert.collection.RadioViewHolder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 10/8/23.
 */

interface RadioDialogBuilder<T> {

    fun setIcon(@DrawableRes iconRes: Int): RadioDialogBuilder<T>

    fun setTitle(@StringRes title: Int): RadioDialogBuilder<T>
    fun setTitle(title: String): RadioDialogBuilder<T>

    fun setMessage(@StringRes message: Int): RadioDialogBuilder<T>
    fun setMessage(message: String): RadioDialogBuilder<T>

    fun setPositiveButtonTitle(@StringRes title: Int): RadioDialogBuilder<T>
    fun setPositiveButtonTitle(title: String): RadioDialogBuilder<T>

    fun setNegativeButtonTitle(@StringRes title: Int): RadioDialogBuilder<T>
    fun setNegativeButtonTitle(title: String): RadioDialogBuilder<T>

    fun setCancelable(isCancelable: Boolean): RadioDialogBuilder<T>
    fun setInteraction(value: RecyclerAdapterInteraction<T>): RadioDialogBuilder<T>
    
    interface RecyclerAdapterInteraction<T> {
        fun onCreateViewHolder(parent: ViewGroup): RadioViewHolder {
            val binding = BreezRowRadioLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return BreezRadioViewHolder(binding)
        }

        fun getItemSize(): Int
        fun getModel(position: Int): T
        fun onSelected(position: Int)
    }
}