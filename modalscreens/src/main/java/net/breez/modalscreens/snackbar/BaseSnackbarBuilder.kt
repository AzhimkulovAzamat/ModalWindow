package net.breez.modalscreens.snackbar

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.Margins
import net.breez.modalscreens.R
import net.breez.modalscreens.dp
import net.breez.modalscreens.snackbar.simple.SimpleSnackbarBuilder

/**
 * Created by azamat on 9/8/23.
 */

abstract class BaseSnackbarBuilder : SnackbarBuilder {

    private var gravity: Int = Gravity.TOP
    private var length: Int = Snackbar.LENGTH_LONG
    private var margins: Margins = Margins()
    @DrawableRes
    @ColorRes
    private var background: Int? = R.drawable.default_snackbar_background

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun bind(view: View, snackbar: Snackbar)

    override fun setBackground(resourceId: Int): SnackbarBuilder {
        background = resourceId
        return this
    }

    override fun setLength(length: Int): SnackbarBuilder {
        this.length = length
        return this
    }

    override fun setGravity(gravity: Int): SnackbarBuilder {
        this.gravity = gravity
        return this
    }

    override fun setMargins(margin: Margins): SnackbarBuilder {
        margins = margin
        return this
    }

    override fun create(container: View): Snackbar {
        val snackbar = Snackbar.make(container, "", length)
        val layout = snackbar.view as Snackbar.SnackbarLayout
        LayoutInflater.from(container.context).inflate(layoutRes, layout, true)
        val view = layout.children.last()

        (layout.layoutParams as? FrameLayout.LayoutParams)?.gravity = gravity
        removeInitialView(layout)

        bind(view, snackbar)
        background?.let { view.setBackgroundResource(it) }

        return snackbar
    }

    private fun removeInitialView(layout: Snackbar.SnackbarLayout) {
        (layout.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView).visibility =
            View.INVISIBLE
        layout.setBackgroundResource(android.R.color.transparent)
        layout.setPadding(
            margins.start.dp(layout.context).toInt(),
            margins.start.dp(layout.context).toInt(),
            margins.start.dp(layout.context).toInt(),
            margins.start.dp(layout.context).toInt()
        )
    }
}