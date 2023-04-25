package net.breez.modalscreens.alert.alternative

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.*
import net.breez.modalscreens.model.DialogModel
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 23/4/23.
 */

class AlternativeDialogBuilder(private val dialogViewHolder: DialogViewHolderContract = DialogBuilderPreferences.alternativeViewHolder) :
    AlternativeDialogBuilderContract {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onPositiveClicked: OnClickedListener? = null
    private var positiveButtonTitle: StringOrResource? = null

    private var onNegativeClicked: OnClickedListener? = null
    private var negativeButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = false
    private var backgroundId: Int = R.drawable.default_dialog_bakground

    private val customViewSetters = mutableMapOf<Int, CustomViewSetter>()

    private var dialogModel: DialogModel? = null

    override fun setIcon(drawableId: Int): AlternativeDialogBuilder {
        this.icon = drawableId
        return this
    }

    override fun setTitle(title: Int): AlternativeDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setTitle(title: String): AlternativeDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setMessage(message: Int): AlternativeDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setMessage(message: String): AlternativeDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setPositiveButtonTitle(title: Int): AlternativeDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveButtonTitle(title: String): AlternativeDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveButtonClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilder {
        this.onPositiveClicked = onClicked
        return this
    }

    override fun setNegativeTitle(title: Int): AlternativeDialogBuilder {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeTitle(title: String): AlternativeDialogBuilder {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeClickedListener(onClicked: OnClickedListener): AlternativeDialogBuilder {
        this.onNegativeClicked = onClicked
        return this
    }

    override fun setCancelable(cancelable: Boolean): AlternativeDialogBuilder {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): AlternativeDialogBuilder {
        backgroundId = resourceId
        return this
    }

    override fun setView(
        viewId: Int,
        customViewSetter: CustomViewSetter
    ): AlternativeDialogBuilder {
        customViewSetters[viewId] = customViewSetter
        return this
    }

    override fun fromOptions(messageId: Int): AlternativeDialogBuilder {
        val model = DialogBuilderPreferences.options[messageId]!!

        icon = model.image
        title = model.title
        message = model.message
        positiveButtonTitle = model.positiveTitle
        negativeButtonTitle = model.negativeTitle
        isCancelable = model.isCancelable

        dialogModel = model

        return this
    }

    override fun create(context: Context): AlertDialog {
        dialogViewHolder.initializeView(context)
        icon?.let { dialogViewHolder.setupIcon(it) }
        message?.let { dialogViewHolder.setupMessage(it.getString(context)) }
        dialogViewHolder.setupTitle(title!!.getString(context))
        val alertDialog: AlertDialog =
            AlertDialog.Builder(context).setView(dialogViewHolder.getDialogView()).create()
        dialogViewHolder.setupPositiveButton(positiveButtonTitle!!.getString(context)) {
            onPositiveClicked?.invoke()
            alertDialog.dismiss()
        }
        negativeButtonTitle?.let {
            dialogViewHolder.setupNegativeButton(it.getString(context)) {
                onNegativeClicked?.invoke()
                alertDialog.dismiss()
            }
        }
        dialogModel?.let { dialogViewHolder.setDialogModel(it, dialogViewHolder.getDialogView()) }
        alertDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogViewHolder.setBackground(backgroundId)

        customViewSetters.forEach { item ->
            val view = dialogViewHolder.getDialogView().findViewById<View>(item.key)
            item.value(view)
        }

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }
}