package net.breez.modalscreens.alert

import android.content.Context
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.ModalType

interface DialogBuilder {

    fun create(context: Context, modalType: ModalType? = null): AlertDialog
}