package net.breez.modalscreens.alert

import android.content.Context
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog

/**
 * Created by azamat on 8/8/23.
 */

interface DialogBuilder {

    fun bind(view: View, dialog: AlertDialog)
    fun setBackground(@DrawableRes resourceId: Int): DialogBuilder

    fun create(context: Context): AlertDialog
}