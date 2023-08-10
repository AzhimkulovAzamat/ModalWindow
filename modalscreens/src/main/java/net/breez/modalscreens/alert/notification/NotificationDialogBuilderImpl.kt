package net.breez.modalscreens.alert.notification

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.ModalWindowConfig
import net.breez.modalscreens.R
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.alert.BaseDialogBuilder
import net.breez.modalscreens.databinding.BreezNotificationDialogLayoutBinding
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 9/8/23.
 */

class NotificationDialogBuilderImpl() :
    BaseDialogBuilder(), NotificationDialogBuilder {

    @DrawableRes
    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null
    private var positiveButtonTitle: StringOrResource? = null
    private var isCancelable: Boolean = true
    override val layoutRes: Int
        get() = ModalWindowConfig.notificationLayoutId

    override fun setIcon(iconRes: Int): NotificationDialogBuilder {
        this.icon = iconRes
        return this
    }

    override fun setTitle(title: Int): NotificationDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setTitle(title: String): NotificationDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setMessage(message: Int): NotificationDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setMessage(message: String): NotificationDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: Int): NotificationDialogBuilder {
        positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: String): NotificationDialogBuilder {
        positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setCancelable(isCancelable: Boolean): NotificationDialogBuilder {
        this.isCancelable = isCancelable
        return this
    }

    override fun bind(view: View, dialog: AlertDialog) {
        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)

        textViewTitle.text = title?.getString(view.context)
        textViewMessage.text = message?.getString(view.context)
        positiveButton.text = positiveButtonTitle?.getString(view.context)
        icon?.let { imageViewIcon.setImageResource(it) }
        dialog.setCancelable(isCancelable)
    }
}