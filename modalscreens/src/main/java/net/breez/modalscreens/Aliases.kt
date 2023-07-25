package net.breez.modalscreens

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import net.breez.modalscreens.alert.radio.RadioViewHolder

/**
 * Created by azamat on 1/3/23.
 */


typealias OnClickedListener = () -> Unit

typealias CustomViewSetter = (View) -> Unit

typealias RadioDialogRVAdapter = RecyclerView.Adapter<RadioViewHolder>