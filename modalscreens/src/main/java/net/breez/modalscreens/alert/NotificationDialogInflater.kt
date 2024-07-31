package net.breez.modalscreens.alert

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import net.breez.dialogs.R

internal class NotificationDialogInflater : DialogInflater {

    override fun inflate(view: View, settings: SimpleDialogSettings, finish: () -> Unit) {
        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)

        settings.apply {
            icon?.let {
                imageViewIcon.setImageResource(it)
            }
            title?.let {
                textViewTitle.visibility = View.VISIBLE
                textViewTitle.text = it.getString(view.context)
            }
            message?.let {
                textViewMessage.visibility = View.VISIBLE
                textViewMessage.text = it.getString(view.context)
            }

            positiveButton.text = settings.positiveSetup?.title?.getString(view.context)
            positiveButton.setOnClickListener {
                if (settings.positiveSetup?.action?.invoke(view) == true) {
                    finish()
                }
            }
        }
    }
}

internal class AlternativeDialogInflater : DialogInflater {

    override fun inflate(view: View, settings: SimpleDialogSettings, finish: () -> Unit) {
        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
        val negativeButton = view.findViewById<Button>(R.id.negativeButton)
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)

        settings.apply {
            icon?.let { imageViewIcon.setImageResource(it) }
            title?.let {
                textViewTitle.visibility = View.VISIBLE
                textViewTitle.text = it.getString(view.context)
            }
            message?.let {
                textViewMessage.visibility = View.VISIBLE
                textViewMessage.text = it.getString(view.context)
            }

            positiveButton.text = settings.positiveSetup?.title?.getString(view.context)
            positiveButton.setOnClickListener {
                if (settings.positiveSetup?.action?.invoke(view) == true) {
                    finish()
                }
            }

            negativeButton.text = settings.negativeSetup?.title?.getString(view.context)
            negativeButton.setOnClickListener {
                if (settings.negativeSetup?.action?.invoke(view) == true) {
                    finish()
                }
            }
        }
    }
}

internal interface DialogInflater {

    fun inflate(view: View, settings: SimpleDialogSettings, finish: () -> Unit)
}