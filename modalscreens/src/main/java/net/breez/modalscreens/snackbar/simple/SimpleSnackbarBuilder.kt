package net.breez.modalscreens.snackbar.simple

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.R
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.databinding.BreezSnackbarLayoutBinding
import net.breez.modalscreens.snackbar.BaseSnackbarBuilder
import net.breez.modalscreens.snackbar.SnackbarBuilder
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 9/8/23.
 */

interface SimpleSnackbarBuilder: SnackbarBuilder {

    fun setIcon(@DrawableRes icon: Int): SimpleSnackbarBuilder

    fun setMessage(@StringRes title: Int): SimpleSnackbarBuilder
    fun setMessage(title: String): SimpleSnackbarBuilder
    fun setMessageColor(@ColorRes color: Int): SimpleSnackbarBuilder

    fun setCloseIcon(@DrawableRes icon: Int): SimpleSnackbarBuilder
}

class SimpleSnackbarBuilderImpl(): BaseSnackbarBuilder(),
    SimpleSnackbarBuilder {

    @DrawableRes
    private var icon: Int? = null
    private var message: StringOrResource? = null
    @ColorRes
    private var messageColor: Int? = null
    @DrawableRes
    private var closeIcon: Int? = null
    @DrawableRes @ColorRes
    private var background: Int? = null
    override val layoutRes: Int
        get() = R.layout.breez_snackbar_layout

    override fun setBackground(resourceId: Int): SnackbarBuilder {
        background = resourceId
        return this
    }

    override fun setIcon(icon: Int): SimpleSnackbarBuilder {
        this.icon = icon
        return this
    }

    override fun setMessage(title: Int): SimpleSnackbarBuilder {
        this.message = title.toSOR()
        return this
    }

    override fun setMessage(title: String): SimpleSnackbarBuilder {
        this.message = title.toSOR()
        return this
    }

    override fun setMessageColor(color: Int): SimpleSnackbarBuilder {
        this.messageColor = color
        return this
    }

    override fun setCloseIcon(icon: Int): SimpleSnackbarBuilder {
        this.closeIcon = icon
        return this
    }

    override fun bind(view: View, snackbar: Snackbar) {
        background?.let { view.setBackgroundResource(it) }

        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        textViewTitle.text = message?.getString(view.context)

        messageColor?.let {
            textViewTitle.setTextColor(ContextCompat.getColor(view.context, it))
        }

        val imageViewLogo = view.findViewById<ImageView>(R.id.imageView_logo)
        icon?.let { imageViewLogo.setImageResource(it) }

        val imageViewClose = view.findViewById<ImageView>(R.id.imageView_close)
        closeIcon?.let {
            imageViewClose.setImageResource(it)
            imageViewClose.setOnClickListener {
                snackbar.dismiss()
            }
        }

    }
}