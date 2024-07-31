package net.breez.modalscreens.alert

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import net.breez.dialogs.ModalType
import net.breez.dialogs.ModalWindowConfig

abstract class BaseDialogBuilder : DialogBuilder {

    abstract fun bind(view: View, dialog: AlertDialog)

    abstract fun provideLayout(context: Context, modalType: ModalType?): View

    override fun create(context: Context, modalType: ModalType?): AlertDialog {
        val rootView = provideLayout(context, modalType)
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(rootView).create()

        bind(rootView, alertDialog)

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return alertDialog
    }
}