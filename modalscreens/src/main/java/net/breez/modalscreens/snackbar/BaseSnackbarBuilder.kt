package net.breez.modalscreens.snackbar

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.children
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.Margins
import net.breez.modalscreens.dp

/**
 * Created by azamat on 9/8/23.
 */

abstract class BaseSnackbarBuilder : SnackbarBuilder {

    private var gravity: Int = Gravity.TOP
    private var length: Int = Snackbar.LENGTH_LONG
    private var margins: Margins = Margins.horizontal(6)

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun bind(view: View, snackbar: Snackbar)

    override fun setLength(length: Int): SnackbarBuilder {
        this.length = length
        return this
    }

    override fun setGravity(gravity: Int): SnackbarBuilder {
        this.gravity = gravity
        return this
    }

    override fun create(container: View): Snackbar {
        val snackbar = Snackbar.make(container, "", length)
        val layout = snackbar.view as Snackbar.SnackbarLayout
        LayoutInflater.from(container.context).inflate(layoutRes, layout, true)
        val view = layout.children.last()

        (layout.layoutParams as? FrameLayout.LayoutParams)?.gravity = gravity
        (layout.layoutParams as? FrameLayout.LayoutParams)?.setMargins(
            margins.start.dp(container.context).toInt(),
            margins.top.dp(container.context).toInt(),
            margins.end.dp(container.context).toInt(),
            margins.bottom.dp(container.context).toInt()
        )
        removeInitialView(layout)

        bind(view, snackbar)

        return snackbar
    }

    private fun removeInitialView(layout: Snackbar.SnackbarLayout) {
        (layout.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView).visibility =
            View.INVISIBLE
        layout.setBackgroundResource(android.R.color.transparent)
        layout.setPadding(0, 0, 0, 0)
    }
}