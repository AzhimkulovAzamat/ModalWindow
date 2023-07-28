package net.breez.modalscreens.bottom.sheet

import android.content.Context
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetDialog
import net.breez.modalscreens.CustomViewSetter

/**
 * Created by azamat on 26/7/23.
 */

class BaseBottomSheetBuilder : BottomSheetBuilder {
    @LayoutRes
    private var layoutId: Int? = null
    private var customViewSetter: CustomViewSetter? = null
    private var bottomSheetViewHolder: BottomSheetViewHolder? = null
    private var cancelable: Boolean = true

    override var dismiss: () -> Unit = {}

    override fun setViewHolder(bottomSheetViewHolder: BottomSheetViewHolder): BottomSheetBuilder {
        this.bottomSheetViewHolder = bottomSheetViewHolder
        this.layoutId = bottomSheetViewHolder.layoutId
        return this
    }

    override fun setView(layoutId: Int, customViewSetter: CustomViewSetter): BottomSheetBuilder {
        this.layoutId = layoutId
        this.customViewSetter = customViewSetter
        return this
    }

    override fun setCancelable(cancelable: Boolean): BottomSheetBuilder {
        this.cancelable = cancelable
        return this
    }

    override fun create(context: Context): BottomSheetDialog {
        val view = LayoutInflater.from(context).inflate(layoutId!!, null)
        val dialog = BottomSheetDialog(context)

        dismiss = { dialog.dismiss() }
        customViewSetter?.invoke(view)
        bottomSheetViewHolder?.bind(view)
        dialog.setContentView(view!!)
        dialog.setCancelable(cancelable)
        return dialog
    }
}