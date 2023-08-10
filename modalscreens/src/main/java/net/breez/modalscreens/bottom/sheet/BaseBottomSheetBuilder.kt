package net.breez.modalscreens.bottom.sheet

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * Created by azamat on 26/7/23.
 */

abstract class BaseBottomSheetBuilder(@LayoutRes val layoutId: Int) : BottomSheetBuilder {

    override fun create(context: Context): BottomSheetDialog {
        val view = LayoutInflater.from(context).inflate(layoutId, null)
        val dialog = BottomSheetDialog(context)

        bind(view, dialog)
        dialog.setContentView(view!!)
        return dialog
    }
}