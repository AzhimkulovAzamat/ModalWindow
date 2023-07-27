package net.breez.modalscreens.bottom.sheet

import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by azamat on 27/7/23.
 */

abstract class BottomSheetViewHolder(@LayoutRes val layoutId: Int) {

    abstract fun bind(view: View)
}