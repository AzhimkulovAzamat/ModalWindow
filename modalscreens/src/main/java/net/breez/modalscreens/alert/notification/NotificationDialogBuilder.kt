package net.breez.modalscreens.alert.notification

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.*
import net.breez.modalscreens.model.DialogModel
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 22/4/23.
 */

class NotificationDialogBuilder(private val dialogViewHolder: NotificationDialogViewHolderContract = DialogBuilderPreferences.notificationViewHolder) :
    NotificationDialogBuilderContract {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onPositiveClicked: OnClickedListener? = null
    private var positiveButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = false
    private var backgroundId: Int = R.drawable.default_dialog_bakground

    private val customViewSetters = mutableMapOf<Int, CustomViewSetter>()

    private var dialogModel: DialogModel? = null

    override fun setIcon(drawableId: Int): NotificationDialogBuilder {
        this.icon = drawableId
        return this
    }

    override fun setTitle(title: Int): NotificationDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setTitle(title: String): NotificationDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setMessage(message: Int): NotificationDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setMessage(message: String): NotificationDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setConfirmButtonTitle(title: Int): NotificationDialogBuilderContract {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setConfirmButtonTitle(title: String): NotificationDialogBuilderContract {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setConfirmButtonClickedListener(onClicked: OnClickedListener): NotificationDialogBuilderContract {
        this.onPositiveClicked = onClicked
        return this
    }

    override fun setCancelable(cancelable: Boolean): NotificationDialogBuilderContract {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): NotificationDialogBuilderContract {
        backgroundId = resourceId
        return this
    }

    override fun setView(
        viewId: Int,
        customViewSetter: CustomViewSetter
    ): NotificationDialogBuilderContract {
        customViewSetters[viewId] = customViewSetter
        return this
    }

    override fun fromOptions(messageId: Int): NotificationDialogBuilderContract {
        val model = DialogBuilderPreferences.options[messageId]!!

        icon = model.image
        title = model.title
        message = model.message
        positiveButtonTitle = model.positiveTitle
        isCancelable = model.isCancelable

        dialogModel = model

        return this
    }

    override fun create(context: Context): AlertDialog {
        dialogViewHolder.initializeView(context)
        icon?.let { dialogViewHolder.setupIcon(it) }
        message?.let { dialogViewHolder.setupMessage(it.getString(context)) }
        dialogViewHolder.setupTitle(title!!.getString(context))
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(dialogViewHolder.getDialogView()).create()
        dialogViewHolder.setupSubmitButton(positiveButtonTitle!!.getString(context)) {
            onPositiveClicked?.invoke()
            alertDialog.dismiss()
        }
        dialogModel?.let { dialogViewHolder.setDialogModel(it, dialogViewHolder.getDialogView()) }
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogViewHolder.setBackground(backgroundId)

        customViewSetters.forEach { item ->
            val view = dialogViewHolder.getDialogView().findViewById<View>(item.key)
            item.value(view)
        }

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }
}