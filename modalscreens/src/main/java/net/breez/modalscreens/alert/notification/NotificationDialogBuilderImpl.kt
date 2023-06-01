package net.breez.modalscreens.alert.notification

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.*
import net.breez.modalscreens.DialogBuilderPreferences.defaultNotificationLayoutIds
import net.breez.modalscreens.model.DialogModel
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 22/4/23.
 */

class NotificationDialogBuilderImpl(
    notificationLayoutIdSetup: NotificationLayoutIdSetup = defaultNotificationLayoutIds,
    private val dialogViewHolder: NotificationDialogViewHolderContract = NotificationDialogViewHolder(
        notificationLayoutIdSetup
    )
) :
    NotificationDialogBuilder {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onPositiveClicked: OnClickedListener? = null
    private var positiveButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = false

    private val customViewSetters = mutableMapOf<Int, CustomViewSetter>()

    private var dialogModel: DialogModel? = null
    override var dismiss: () -> Unit = {}

    override fun setIcon(drawableId: Int): NotificationDialogBuilderImpl {
        this.icon = drawableId
        return this
    }

    override fun setTitle(title: Int): NotificationDialogBuilderImpl {
        this.title = StringOrResource(title)
        return this
    }

    override fun setTitle(title: String): NotificationDialogBuilderImpl {
        this.title = StringOrResource(title)
        return this
    }

    override fun setMessage(message: Int): NotificationDialogBuilderImpl {
        this.message = StringOrResource(message)
        return this
    }

    override fun setMessage(message: String): NotificationDialogBuilderImpl {
        this.message = StringOrResource(message)
        return this
    }

    override fun setConfirmButtonTitle(title: Int): NotificationDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setConfirmButtonTitle(title: String): NotificationDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setConfirmButtonClickedListener(onClicked: OnClickedListener): NotificationDialogBuilder {
        this.onPositiveClicked = onClicked
        return this
    }

    override fun setCancelable(cancelable: Boolean): NotificationDialogBuilder {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): NotificationDialogBuilder {
        throw UnsupportedOperationException()
    }

    override fun setView(
        viewId: Int,
        customViewSetter: CustomViewSetter
    ): NotificationDialogBuilder {
        customViewSetters[viewId] = customViewSetter
        return this
    }

    override fun fromOptions(dialogId: Int): NotificationDialogBuilder {
        val model = DialogBuilderPreferences.options[dialogId]!!

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
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(dialogViewHolder.getDialogView()).create()
        dismiss = { alertDialog.dismiss() }
        icon?.let { dialogViewHolder.setupIcon(it) }
        message?.let { dialogViewHolder.setupMessage(it.getString(context)) }
        dialogViewHolder.setupTitle(title!!.getString(context))
        dialogViewHolder.setupSubmitButton(positiveButtonTitle!!.getString(context)) {
            onPositiveClicked?.invoke()
            dismiss()
        }
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogViewHolder.setBackground(DialogBuilderPreferences.backgroundId)

        customViewSetters.forEach { item ->
            val view = dialogViewHolder.getDialogView().findViewById<View>(item.key)
            item.value(view)
        }

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }
}