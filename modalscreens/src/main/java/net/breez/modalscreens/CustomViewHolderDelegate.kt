package net.breez.modalscreens

import android.view.View
import net.breez.modalscreens.model.DialogModel

/**
 * Created by azamat on 6/3/23.
 */

interface CustomViewHolderDelegate {
    fun setDialogModel(dialogModel: DialogModel, dialogView: View)
}