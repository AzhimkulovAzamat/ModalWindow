package net.breez.modalscreens.alert.radio

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.breez.modalscreens.AlertDialogBuilderConfig
import net.breez.modalscreens.AlertDialogBuilderConfig.Companion.defaultRadioLayoutIds
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.R
import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 2/6/23.
 */

class RadioDialogBuilderImpl(
    alternativeLayoutIdSetup: RadioLayoutIdSetup = defaultRadioLayoutIds,
) : RadioDialogBuilder, RadioLayoutIdSetup by alternativeLayoutIdSetup {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onPositiveClicked: OnClickedListener? = null
    private var positiveButtonTitle: StringOrResource? = null

    private var onNegativeClicked: OnClickedListener? = null
    private var negativeButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = true

    override var dismiss: () -> Unit = {}

    private var interaction: RecyclerAdapterInteraction? = null

    interface RecyclerAdapterInteraction {
        fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder
        fun onBindViewHolder(holder: RadioViewHolder, position: Int)
        fun getItemSize(): Int
    }

    override fun setIcon(drawableId: Int): RadioDialogBuilder {
        this.icon = drawableId
        return this
    }

    override fun setTitle(title: Int): RadioDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setTitle(title: String): RadioDialogBuilder {
        this.title = StringOrResource(title)
        return this
    }

    override fun setMessage(message: Int): RadioDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setMessage(message: String): RadioDialogBuilder {
        this.message = StringOrResource(message)
        return this
    }

    override fun setPositiveTitle(title: Int): RadioDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveTitle(title: String): RadioDialogBuilder {
        this.positiveButtonTitle = StringOrResource(title)
        return this
    }

    override fun setPositiveClickedListener(onClicked: OnClickedListener): RadioDialogBuilder {
        this.onPositiveClicked = onClicked
        return this
    }

    override fun setNegativeTitle(title: Int): RadioDialogBuilder {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeTitle(title: String): RadioDialogBuilder {
        this.negativeButtonTitle = StringOrResource(title)
        return this
    }

    override fun setNegativeClickedListener(onClicked: OnClickedListener): RadioDialogBuilder {
        this.onNegativeClicked = onClicked
        return this
    }

    override fun setCancelable(cancelable: Boolean): RadioDialogBuilder {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): RadioDialogBuilder {
        throw UnsupportedOperationException()
    }

    override fun setInteraction(value: RecyclerAdapterInteraction): RadioDialogBuilder {
        interaction = value
        return this
    }

    override fun fromOptions(dialogId: Int): RadioDialogBuilder {
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
            .inflate(AlertDialogBuilderConfig.radioLayoutId, null, false)
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
        setupRecyclerView(rootView.findViewById(recyclerViewId))

        alertDialog.setCancelable(isCancelable)
        return alertDialog
    }

    private fun setupRecyclerView(
        recycler: RecyclerView
    ) {
        recycler.layoutManager =
            LinearLayoutManager(recycler.context, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = object : RecyclerView.Adapter<RadioViewHolder>() {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
                return interaction!!.onCreateViewHolder(parent, viewType)
            }

            override fun getItemCount(): Int = interaction?.getItemSize() ?: 0

            override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
                interaction!!.onBindViewHolder(holder, position)
            }
        }
    }
}