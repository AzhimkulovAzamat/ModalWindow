package net.breez.modalscreens.alert.radio

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by azamat on 24/7/23.
 */

abstract class RadioViewHolder(view: View): RecyclerView.ViewHolder(view) {


    abstract fun select()

    abstract fun deselect()
}