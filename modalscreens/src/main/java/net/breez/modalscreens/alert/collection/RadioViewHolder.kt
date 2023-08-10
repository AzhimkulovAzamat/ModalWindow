package net.breez.modalscreens.alert.collection

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by azamat on 24/7/23.
 */

abstract class RadioViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(data: Any)
    abstract fun isSelected(selected:Boolean)
}