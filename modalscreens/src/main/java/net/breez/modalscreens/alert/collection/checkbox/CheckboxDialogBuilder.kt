package net.breez.modalscreens.alert.collection.checkbox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.alert.collection.BreezRadioViewHolder
import net.breez.modalscreens.alert.collection.RadioViewHolder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 10/8/23.
 */

//interface CheckboxDialogBuilder: DialogBuilder {
//
//    fun setIcon(@DrawableRes iconRes: Int): CheckboxDialogBuilder
//
//    fun setTitle(@StringRes title: Int): CheckboxDialogBuilder
//    fun setTitle(title: String): CheckboxDialogBuilder
//
//    fun setMessage(@StringRes message: Int): CheckboxDialogBuilder
//    fun setMessage(message: String): CheckboxDialogBuilder
//
//    fun setPositiveButtonTitle(@StringRes title: Int): CheckboxDialogBuilder
//    fun setPositiveButtonTitle(title: String): CheckboxDialogBuilder
//
//    fun setNegativeButtonTitle(@StringRes title: Int): CheckboxDialogBuilder
//    fun setNegativeButtonTitle(title: String): CheckboxDialogBuilder
//
//    fun setPositiveClickListener(listener: OnClickedListener): CheckboxDialogBuilder
//    fun setNegativeClickListener(listener: OnClickedListener): CheckboxDialogBuilder
//
//    fun setCancelable(isCancelable: Boolean): CheckboxDialogBuilder
//    fun setInteraction(value: RecyclerAdapterInteraction): CheckboxDialogBuilder
//
//
//    interface RecyclerAdapterInteraction {
//        fun onCreateViewHolder(parent: ViewGroup): RadioViewHolder {
//            val binding = BreezRowRadioLayoutBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//            return BreezRadioViewHolder(binding)
//        }
//
//        fun getItemSize(): Int
//        fun getModel(position: Int): Any
//        fun onItemClicked(position: Int)
//        fun isSelected(position: Int): Boolean
//    }
//}