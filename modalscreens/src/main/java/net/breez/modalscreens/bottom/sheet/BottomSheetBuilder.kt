package net.breez.modalscreens.bottom.sheet

import android.content.Context
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by azamat on 26/7/23.
 */

interface BottomSheetBuilder {

    fun create(context: Context): BottomSheetDialog
}