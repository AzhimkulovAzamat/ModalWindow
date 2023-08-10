package net.breez.modalscreens.alert.alternative

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
import net.breez.modalscreens.databinding.BreezAlternativeDialogLayoutBinding
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 9/8/23.
 */

open class AlternativeDialogBuilderImpl : BaseDialogBuilder(),
    AlternativeDialogBuilder {


    @DrawableRes
    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null
    private var positiveButtonTitle: StringOrResource? = null
    private var negativeButtonTitle: StringOrResource? = null
    private var isCancelable: Boolean = true
    override val layoutRes: Int
        get() = ModalWindowConfig.alternativeLayoutId

    override fun setIcon(iconRes: Int): AlternativeDialogBuilder {
        this.icon = iconRes
        return this
    }

    override fun setTitle(title: Int): AlternativeDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setTitle(title: String): AlternativeDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setMessage(message: Int): AlternativeDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setMessage(message: String): AlternativeDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: Int): AlternativeDialogBuilder {
        positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: String): AlternativeDialogBuilder {
        positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setNegativeButtonTitle(title: Int): AlternativeDialogBuilder {
        this.negativeButtonTitle = title.toSOR()
        return this
    }

    override fun setNegativeButtonTitle(title: String): AlternativeDialogBuilder {
        this.negativeButtonTitle = title.toSOR()
        return this
    }

    override fun setCancelable(isCancelable: Boolean): AlternativeDialogBuilder {
        this.isCancelable = isCancelable
        return this
    }

    override fun bind(view: View, dialog: AlertDialog) {
        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
        val negativeButton = view.findViewById<Button>(R.id.negativeButton)
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)

        textViewTitle.text = title?.getString(view.context)
        textViewMessage.text = message?.getString(view.context)
        positiveButton.text = positiveButtonTitle?.getString(view.context)
        negativeButton.text = negativeButtonTitle?.getString(view.context)
        icon?.let { imageViewIcon.setImageResource(it) }
        dialog.setCancelable(isCancelable)
    }
}