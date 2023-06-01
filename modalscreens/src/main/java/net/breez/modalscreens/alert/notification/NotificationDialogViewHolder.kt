package net.breez.modalscreens.alert.notification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.breez.modalscreens.DialogBuilderPreferences
import net.breez.modalscreens.NotificationDialogViewHolderContract

/**
 * Created by azamat on 1/6/23.
 */

open class NotificationDialogViewHolder(notificationLayoutIdSetup: NotificationLayoutIdSetup) :
    NotificationDialogViewHolderContract, NotificationLayoutIdSetup by notificationLayoutIdSetup {

    private lateinit var rootView: View

    private val iconView: ImageView by lazy { getViewById(iconViewId) }
    private val titleView: TextView by lazy { getViewById(titleViewId) }
    private val messageView: TextView by lazy { getViewById(messageViewId) }
    private val submitButton: TextView by lazy { getViewById(submitButtonId) }

    override fun initializeView(context: Context): NotificationDialogViewHolderContract {
        rootView = LayoutInflater.from(context)
            .inflate(DialogBuilderPreferences.notificationLayoutId, null, false)
        return this
    }

    override fun setupIcon(drawableId: Int): NotificationDialogViewHolderContract {
        iconView.setImageResource(drawableId)
        return this
    }

    override fun setupTitle(value: String): NotificationDialogViewHolderContract {
        titleView.text = value
        return this
    }

    override fun setupMessage(value: String): NotificationDialogViewHolderContract {
        messageView.text = value
        return this
    }

    override fun setupSubmitButton(
        value: String,
        onClicked: () -> Unit
    ): NotificationDialogViewHolderContract {
        submitButton.text = value
        submitButton.setOnClickListener { onClicked() }
        return this
    }

    override fun setBackground(backgroundId: Int): NotificationDialogViewHolderContract {
        rootView.setBackgroundResource(backgroundId)
        return this
    }

    override fun getDialogView(): View {
        return rootView
    }

    private fun <T : View> getViewById(resourceId: Int): T {
        return rootView.findViewById(resourceId)
    }
}