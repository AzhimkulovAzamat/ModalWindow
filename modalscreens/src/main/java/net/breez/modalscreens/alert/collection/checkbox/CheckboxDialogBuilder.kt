package net.breez.modalscreens.alert.collection.checkbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.alert.collection.BreezRadioViewHolder
import net.breez.modalscreens.alert.collection.RadioViewHolder
import net.breez.modalscreens.alert.collection.radio.RadioDialogBuilder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 10/8/23.
 */

interface CheckboxDialogBuilder<T> {

    fun setIcon(@DrawableRes iconRes: Int): CheckboxDialogBuilder<T>

    fun setTitle(@StringRes title: Int): CheckboxDialogBuilder<T>
    fun setTitle(title: String): CheckboxDialogBuilder<T>

    fun setMessage(@StringRes message: Int): CheckboxDialogBuilder<T>
    fun setMessage(message: String): CheckboxDialogBuilder<T>

    fun setPositiveButtonTitle(@StringRes title: Int): CheckboxDialogBuilder<T>
    fun setPositiveButtonTitle(title: String): CheckboxDialogBuilder<T>

    fun setNegativeButtonTitle(@StringRes title: Int): CheckboxDialogBuilder<T>
    fun setNegativeButtonTitle(title: String): CheckboxDialogBuilder<T>

    fun setCancelable(isCancelable: Boolean): CheckboxDialogBuilder<T>
    fun setInteraction(value: RecyclerAdapterInteraction<T>): CheckboxDialogBuilder<T>


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
        fun onItemClicked(position: Int)
        fun isSelected(position: Int): Boolean
    }
}