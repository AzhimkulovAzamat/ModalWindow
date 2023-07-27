package net.breez.modalscreens.alert.radio

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.breez.modalscreens.alert.AlertDialogBuilderConfig
import net.breez.modalscreens.alert.AlertDialogBuilderConfig.Companion.defaultRadioLayoutIds
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding
import net.breez.modalscreens.StringOrResource

/**
 * Created by azamat on 2/6/23.
 */

class RadioDialogBuilderImpl(
    alternativeLayoutIdSetup: RadioLayoutIdSetup = defaultRadioLayoutIds,
) : RadioDialogBuilder, RadioLayoutIdSetup by alternativeLayoutIdSetup {

    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null

    private var onSubmitClicked: OnClickedListener? = null
    private var submitButtonTitle: StringOrResource? = null

    private var onCancelClicked: OnClickedListener? = null
    private var cancelButtonTitle: StringOrResource? = null

    private var isCancelable: Boolean = true

    override var dismiss: () -> Unit = {}

    private var interaction: RecyclerAdapterInteraction? = null

    private var selectedPosition: Int? = null

    interface RecyclerAdapterInteraction {
        fun onCreateViewHolder(parent: ViewGroup): RadioViewHolder {
            val binding = BreezRowRadioLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return BreezRadioViewHolder(binding)
        }

        fun getItemSize(): Int
        fun getModel(position: Int): Any
        fun onSelected(position: Int)
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

    override fun setSubmitTitle(title: Int): RadioDialogBuilder {
        this.submitButtonTitle = StringOrResource(title)
        return this
    }

    override fun setSubmitTitle(title: String): RadioDialogBuilder {
        this.submitButtonTitle = StringOrResource(title)
        return this
    }

    override fun setSubmitClickedListener(onClicked: OnClickedListener): RadioDialogBuilder {
        this.onSubmitClicked = onClicked
        return this
    }

    override fun setCancelTitle(title: Int): RadioDialogBuilder {
        this.cancelButtonTitle = StringOrResource(title)
        return this
    }

    override fun setCancelTitle(title: String): RadioDialogBuilder {
        this.cancelButtonTitle = StringOrResource(title)
        return this
    }

    override fun setCancelClickedListener(onClicked: OnClickedListener): RadioDialogBuilder {
        this.onCancelClicked = onClicked
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
        submitButtonTitle = model.positiveTitle
        cancelButtonTitle = model.negativeTitle
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
        submitButtonTitle?.let {
            rootView.findViewById<TextView>(positiveButtonId).apply {
                visibility = View.VISIBLE
                text = it.getString(context)
                setOnClickListener {
                    onSubmitClicked?.invoke()
                    dismiss()
                }
            }
        }

        cancelButtonTitle?.let {
            rootView.findViewById<TextView>(negativeButtonId).apply {
                visibility = View.VISIBLE
                text = it.getString(context)
                setOnClickListener {
                    onCancelClicked?.invoke()
                    dismiss()
                }
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

            override fun onCreateViewHolder(
                parent: ViewGroup,
                viewType: Int
            ): RadioViewHolder {
                return interaction!!.onCreateViewHolder(parent)
            }

            override fun getItemCount(): Int = interaction?.getItemSize() ?: 0

            override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
                holder.itemView.setOnClickListener {
                    notifyItemChanged(selectedPosition ?: 0)
                    selectedPosition = holder.adapterPosition
                    notifyItemChanged(selectedPosition ?: 0)
                    interaction?.onSelected(position)
                    if (submitButtonTitle == null) {
                        dismiss()
                    }
                }
                holder.isSelected(selectedPosition == position)
                interaction?.getModel(position)?.let { holder.bind(it) }
            }
        }
    }
}