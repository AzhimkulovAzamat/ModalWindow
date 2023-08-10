package net.breez.modalscreens.snackbar

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.view.children
import com.google.android.material.snackbar.Snackbar

/**
 * Created by azamat on 9/8/23.
 */

abstract class BaseSnackbarBuilder() : SnackbarBuilder {

    private var gravity: Int = Gravity.TOP
    private var length: Int = Snackbar.LENGTH_LONG

    @get:LayoutRes
    abstract val layoutRes: Int

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