package net.breez.modalscreens.alert.notification

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.*
import net.breez.modalscreens.DialogBuilderPreferences.defaultNotificationLayoutIds
import net.breez.modalscreens.alert.alternative.AlternativeDialogBuilderImpl
import net.breez.modalscreens.model.DialogModel
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 22/4/23.
 */

class NotificationDialogBuilderImpl(
    notificationLayoutIdSetup: NotificationLayoutIdSetup = defaultNotificationLayoutIds
) :
    NotificationDialogBuilder, NotificationLayoutIdSetup by notificationLayoutIdSetup {

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
        val rootView = LayoutInflater.from(context)
            .inflate(DialogBuilderPreferences.notificationLayoutId, null, false)
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(rootView).create()
        dismiss = { alertDialog.dismiss() }
        icon?.let { rootView.findViewById<ImageView>(iconViewId).setImageResource(it) }
        message?.let { rootView.findViewById<TextView>(messageViewId).text = it.getString(context) }
        rootView.findViewById<TextView>(titleViewId).text = title!!.getString(context)
        rootView.findViewById<TextView>(submitButtonId).apply {
            text = positiveButtonTitle!!.getString(context)
            setOnClickListener {
                onPositiveClicked?.invoke()
                dismiss()
            }
        }
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        rootView.setBackgroundResource(DialogBuilderPreferences.backgroundId)

        customViewSetters.forEach { item ->
            val view = rootView.findViewById<View>(item.key)
            item.value(view)
        }

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }
}