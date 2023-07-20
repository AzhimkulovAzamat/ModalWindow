package net.breez.modalscreens.alert.alternative

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.AlertDialogBuilderConfig
import net.breez.modalscreens.AlertDialogBuilderConfig.Companion.defaultAlternativeLayoutIds
import net.breez.modalscreens.CustomViewSetter
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 23/4/23.
 */

class AlternativeDialogBuilderImpl(
    alternativeLayoutIdSetup: AlternativeLayoutIdSetup = defaultAlternativeLayoutIds,
) :
    AlternativeDialogBuilder, AlternativeLayoutIdSetup by alternativeLayoutIdSetup {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onPositiveClicked: OnClickedListener? = null
    private var positiveButtonTitle: StringOrResource? = null

    private var onNegativeClicked: OnClickedListener? = null
    private var negativeButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = false

    private val customViewSetters = mutableMapOf<Int, CustomViewSetter>()

    override var dismiss: () -> Unit = {}

    override fun setIcon(drawableId: Int): AlternativeDialogBuilderImpl {
        this.icon = drawableId
        return this
    }

    override fun setTitle(title: Int): AlternativeDialogBuilderImpl {
        this.title = StringOrResource(title)
        return this
    }

    override fun setTitle(title: String): AlternativeDialogBuilderImpl {
        this.title = StringOrResource(title)
        return this
    }

    override fun setMessage(message: Int): AlternativeDialogBuilderImpl {
        this.message = StringOrResource(message)
        return this
    }

    override fun setMessage(message: String): AlternativeDialogBuilderImpl {
        this.message = StringOrResource(message)
        return this
    }

    override fun setPositiveTitle(title: Int): AlternativeDialogBuilderImpl {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveTitle(title: String): AlternativeDialogBuilderImpl {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderImpl {
        this.onPositiveClicked = onClicked
        return this
    }

    override fun setNegativeTitle(title: Int): AlternativeDialogBuilderImpl {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeTitle(title: String): AlternativeDialogBuilderImpl {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilderImpl {
        this.onNegativeClicked = onClicked
        return this
    }

    override fun setCancelable(cancelable: Boolean): AlternativeDialogBuilderImpl {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): AlternativeDialogBuilderImpl {
        throw UnsupportedOperationException()
    }

    override fun setView(
        viewId: Int,
        customViewSetter: CustomViewSetter
    ): AlternativeDialogBuilderImpl {
        customViewSetters[viewId] = customViewSetter
        return this
    }

    override fun fromOptions(dialogId: Int): AlternativeDialogBuilderImpl {
        val model = AlertDialogBuilderConfig.options.getByKey(dialogId)

        icon = model.image
        title = model.title
        message = model.message
        positiveButtonTitle = model.positiveTitle
        negativeButtonTitle = model.negativeTitle
        isCancelable = model.isCancelable

        return this
    }

    override fun create(context: Context): AlertDialog {
        val rootView = LayoutInflater.from(context)
            .inflate(AlertDialogBuilderConfig.alternativeLayoutId, null, false)
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(rootView).create()
        dismiss = { alertDialog.dismiss() }
        icon?.let { rootView.findViewById<ImageView>(iconViewId).setImageResource(it) }
        message?.let {
            rootView.findViewById<TextView>(messageViewId).text = it.getString(context)
        }
        rootView.findViewById<TextView>(titleViewId).text = title!!.getString(context)
        rootView.findViewById<TextView>(positiveButtonId).apply {
            text = positiveButtonTitle!!.getString(context)
            setOnClickListener {
                onPositiveClicked?.invoke()
                dismiss()
            }
        }

        rootView.findViewById<TextView>(negativeButtonId).apply {
            text = negativeButtonTitle!!.getString(context)
            setOnClickListener {
                onNegativeClicked?.invoke()
                dismiss()
            }
        }

        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        rootView.setBackgroundResource(AlertDialogBuilderConfig.backgroundId)

        customViewSetters.forEach { item ->
            val view = rootView.findViewById<View>(item.key)
            item.value(view)
        }

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }
}