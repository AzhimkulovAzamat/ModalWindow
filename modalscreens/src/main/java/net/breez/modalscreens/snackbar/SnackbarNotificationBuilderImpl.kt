package net.breez.modalscreens.snackbar

import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.google.android.material.snackbar.Snackbar
import net.breez.modalscreens.CustomViewSetter

/**
 * Created by azamat on 28/7/23.
 */

class SnackbarNotificationBuilderImpl : SnackbarNotificationBuilder {

    @LayoutRes
    private var layoutId: Int? = null
    private var customViewSetter: CustomViewSetter? = null
    private var snackbarViewHolder: SnackbarViewHolder? = null
    private var gravity: Int? = null

    private var topPadding: Int? = null
    private var bottomPadding: Int? = null
    private var leftPadding: Int? = null
    private var rightPadding: Int? = null

    private var length: Int? = null
    private var snackbarModel:SnackbarModel? = null

    override fun setViewHolder(holder: SnackbarViewHolder): SnackbarNotificationBuilder {
        this.snackbarViewHolder = holder
        this.layoutId = holder.layoutId
        return this
    }

    override fun setView(
        layoutId: Int,
        customViewSetter: CustomViewSetter
    ): SnackbarNotificationBuilder {
        this.layoutId = layoutId
        this.customViewSetter = customViewSetter
        return this
    }


    override fun setDuration(duration: Int): SnackbarNotificationBuilder {
        length = duration
        return this
    }

    override fun setPadding(
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): SnackbarNotificationBuilder {
        this.leftPadding = left
        this.topPadding = top
        this.rightPadding = right
        this.bottomPadding = bottom
        return this
    }

    override fun setGravity(gravity: Int): SnackbarNotificationBuilder {
        this.gravity = gravity
        return this
    }

    override fun fromOptions(optionsId: Int): SnackbarNotificationBuilder {
        val options = SnackbarBuilderConfig.options.getByKey(optionsId)
        snackbarModel = options
        return this
    }

    override fun create(container: View): Snackbar {
        val snackbar = Snackbar.make(container, "", Snackbar.LENGTH_LONG)
        val layout = snackbar.view as Snackbar.SnackbarLayout
        val view = LayoutInflater.from(container.context).inflate(layoutId!!, layout, true)
        snackbarModel?.let { view.setBackgroundResource(it.background) }

        removeInitialView(layout)
        setPaddings(layout)

        snackbarViewHolder?.let { it.bind(view, snackbarModel) {} } ?: kotlin.run {
            SnackbarBuilderConfig.viewHolder.bind(view, snackbarModel) {}
        }
        customViewSetter?.invoke(view)

        length?.let { snackbar.duration = it } ?: kotlin.run {
            snackbar.duration = snackbarModel?.duration ?: Snackbar.LENGTH_LONG
        }

        return snackbar
    }

    private fun removeInitialView(layout: Snackbar.SnackbarLayout) {
        (layout.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView).visibility =
            View.INVISIBLE
        layout.setBackgroundResource(android.R.color.transparent)
        layout.setPadding(0, 0, 0, 0)
    }

    private fun setPaddings(layout: Snackbar.SnackbarLayout) {
        if (leftPadding == null) {
            leftPadding = SnackbarBuilderConfig.padding.left
        }
        if (topPadding == null) {
            topPadding = SnackbarBuilderConfig.padding.top
        }
        if (rightPadding == null) {
            rightPadding = SnackbarBuilderConfig.padding.right
        }
        if (bottomPadding == null) {
            bottomPadding = SnackbarBuilderConfig.padding.bottom
        }

        val params = (layout.layoutParams as? FrameLayout.LayoutParams)
        gravity?.let { params?.gravity = it } ?: kotlin.run {
            params?.gravity = SnackbarBuilderConfig.gravity
        }
        params?.setMargins(
            params.leftMargin + (leftPadding ?: 0),
            params.topMargin + (topPadding ?: 0),
            params.rightMargin + (rightPadding ?: 0),
            params.bottomMargin + (bottomPadding ?: 0)
        )
        params?.let { layout.layoutParams = it }
    }
}