package net.breez.modalscreens.snackbar.simple

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.Margins
import net.breez.modalscreens.ModalWindowConfig
import net.breez.modalscreens.R
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.databinding.BreezSnackbarLayoutBinding
import net.breez.modalscreens.snackbar.BaseSnackbarBuilder
import net.breez.modalscreens.snackbar.SnackbarBuilder
import net.breez.modalscreens.toSOR
import java.lang.ref.WeakReference

/**
 * Created by azamat on 9/8/23.
 */

interface SimpleSnackbarBuilder : SnackbarBuilder {

    fun setIcon(@DrawableRes icon: Int): SimpleSnackbarBuilder
    fun setMessage(@StringRes title: Int): SimpleSnackbarBuilder
    fun setMessage(title: String): SimpleSnackbarBuilder
    fun setMessageColor(@ColorRes color: Int): SimpleSnackbarBuilder
    fun setCloseIcon(@DrawableRes icon: Int): SimpleSnackbarBuilder

    fun setCustomView(
        @IdRes viewId: Int,
        setup: WeakReference<(View) -> Unit>
    ): SimpleSnackbarBuilder

    override fun setBackground(@DrawableRes resourceId: Int): SimpleSnackbarBuilder
    override fun setLength(@IntRange(from = -2, to = 0) length: Int): SimpleSnackbarBuilder
    override fun setGravity(gravity: Int): SimpleSnackbarBuilder
    override fun setMargins(margin: Margins): SimpleSnackbarBuilder
}

open class SimpleSnackbarBuilderImpl : BaseSnackbarBuilder(),
    SimpleSnackbarBuilder {

    @DrawableRes
    private var icon: Int? = null
    private var message: StringOrResource? = null

    @ColorRes
    private var messageColor: Int? = null

    @DrawableRes
    private var closeIcon: Int? = null

    private var customViews = mutableMapOf<Int, WeakReference<(View) -> Unit>>()

    override val layoutRes: Int
        get() = ModalWindowConfig.snackbarLayoutId

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

    override fun setCustomView(
        viewId: Int,
        setup: WeakReference<(View) -> Unit>
    ): SimpleSnackbarBuilder {
        customViews[viewId] = setup
        return this
    }

    override fun setLength(length: Int): SimpleSnackbarBuilder {
        return super.setLength(length) as SimpleSnackbarBuilder
    }

    override fun setGravity(gravity: Int): SimpleSnackbarBuilder {
        return super.setGravity(gravity) as SimpleSnackbarBuilder
    }

    override fun setMargins(margin: Margins): SimpleSnackbarBuilder {
        return super.setMargins(margin) as SimpleSnackbarBuilder
    }

    override fun setBackground(resourceId: Int): SimpleSnackbarBuilder {
        return super.setBackground(resourceId) as SimpleSnackbarBuilder
    }

    override fun bind(view: View, snackbar: Snackbar) {

        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        textViewTitle.text = message?.getString(view.context)

        messageColor?.let {
            textViewTitle.setTextColor(ContextCompat.getColor(view.context, it))
        }

        for (settings in customViews) {
            val customView = view.findViewById<View>(settings.key)
            settings.value.get()?.invoke(customView)
        }

        val imageViewLogo = view.findViewById<ImageView>(R.id.imageView_logo)
        icon?.let {
            imageViewLogo.visibility = View.VISIBLE
            imageViewLogo.setImageResource(it)
        }

        val imageViewClose = view.findViewById<ImageView>(R.id.imageView_close)
        closeIcon?.let {
            imageViewClose.visibility = View.VISIBLE
            imageViewClose.setImageResource(it)
            imageViewClose.setOnClickListener {
                snackbar.dismiss()
            }
        }

    }
}