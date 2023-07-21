package net.breez.modalscreens.alert.radio

import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding

/**
 * Created by azamat on 3/6/23.
 */

abstract class RadioViewHolder(view: View) : ViewHolder(view) {

    abstract fun isSelected(selected: Boolean)
    abstract fun getRadioView(): RadioButton
}