package net.breez.modalscreens.bottom.sheet

import android.content.Context
import android.view.View
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import net.breez.modalscreens.CustomViewSetter

/**
 * Created by azamat on 26/7/23.
 */

interface BottomSheetBuilder {

    fun bind(view: View, bottomSheet: BottomSheetDialog)
    fun create(context: Context): BottomSheetDialog
}