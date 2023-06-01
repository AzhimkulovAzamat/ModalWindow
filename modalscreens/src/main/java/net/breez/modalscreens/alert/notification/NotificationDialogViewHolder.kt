package net.breez.modalscreens.alert.notification

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.breez.modalscreens.*
import net.breez.modalscreens.Simple

/**
 * Created by azamat on 1/6/23.
 */

open class NotificationDialogViewHolder(
    delegate: CustomViewHolderDelegate = DialogBuilderPreferences.notificationViewHolderDelegate
) :
    NotificationDialogViewHolderContract,
    CustomViewHolderDelegate by delegate {

    private lateinit var rootView: View

    override var iconViewId = R.id.imageView_icon
    override var titleViewId = R.id.textView_title
    override var messageViewId = R.id.textView_message

    override var submitButtonId: Int = R.id.positiveButton

    override fun initializeView(context: Context): NotificationDialogViewHolderContract {
        rootView = LayoutInflater.from(context)
            .inflate(DialogBuilderPreferences.notificationLayoutId, null, false)
        return this
    }

    override fun setupIcon(drawableId: Int): NotificationDialogViewHolderContract {
        rootView.findViewById<ImageView>(iconViewId)?.setImageResource(drawableId)
        return this
    }

    override fun setupTitle(value: String): NotificationDialogViewHolderContract {
        rootView.findViewById<TextView>(titleViewId)?.text = value
        return this
    }

    override fun setupMessage(value: String): NotificationDialogViewHolderContract {
        rootView.findViewById<TextView>(messageViewId)?.text = value
        return this
    }

    override fun setupSubmitButton(
        value: String,
        onClicked: () -> Unit
    ): NotificationDialogViewHolderContract {
        rootView.findViewById<TextView>(submitButtonId)?.text = value
        rootView.findViewById<TextView>(submitButtonId)?.setOnClickListener { onClicked() }
        return this
    }

    override fun setBackground(backgroundId: Int): NotificationDialogViewHolderContract {
        rootView.setBackgroundResource(backgroundId)
        return this
    }

    override fun getDialogView(): View {
        return rootView
    }
}