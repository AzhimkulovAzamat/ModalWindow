package net.breez.modalscreens.bottom.sheet

import android.content.Context
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import net.breez.modalscreens.CustomViewSetter

/**
 * Created by azamat on 26/7/23.
 */

interface BottomSheetBuilder {

    fun setCancelable(cancelable: Boolean): BottomSheetBuilder
    fun setView(@LayoutRes layoutId: Int, customViewSetter: CustomViewSetter): BottomSheetBuilder
    fun setViewHolder(bottomSheetViewHolder: BottomSheetViewHolder): BottomSheetBuilder
    fun create(context: Context): BottomSheetDialog
}