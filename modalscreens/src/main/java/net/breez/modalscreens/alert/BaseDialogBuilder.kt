package net.breez.modalscreens.alert

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog

/**
 * Created by azamat on 4/8/23.
 */

abstract class BaseDialogBuilder : DialogBuilder {

    @DrawableRes
    @ColorRes
    private var background: Int? = null

    @get:LayoutRes
    abstract val layoutRes: Int

    override fun setBackground(resourceId: Int): DialogBuilder {
        background = resourceId
        return this
    }

    override fun create(context: Context): AlertDialog {
        val rootView = LayoutInflater.from(context)
            .inflate(layoutRes, null, false)
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(rootView).create()

        bind(rootView, alertDialog)
        background?.let { rootView.setBackgroundResource(it) }

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return alertDialog
    }
}