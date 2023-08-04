package net.breez.modalscreens.alert.multiple.choice

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
import net.breez.modalscreens.OnClickedListener
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.alert.AlertDialogBuilderConfig
import net.breez.modalscreens.alert.radio.BreezRadioViewHolder
import net.breez.modalscreens.alert.radio.RadioLayoutIdSetup
import net.breez.modalscreens.alert.radio.RadioViewHolder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 2/8/23.
 */

class MultiChoiceDialogBuilderImpl(
    alternativeLayoutIdSetup: RadioLayoutIdSetup = AlertDialogBuilderConfig.defaultRadioLayoutIds,
) : MultiChoiceDialogBuilder, RadioLayoutIdSetup by alternativeLayoutIdSetup {

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
        fun onItemClicked(position: Int)
        fun isSelected(position: Int): Boolean
    }

    override fun setTitle(title: Int): MultiChoiceDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setTitle(title: String): MultiChoiceDialogBuilder {
        this.title = title.toSOR()
        return this
    }

    override fun setMessage(message: Int): MultiChoiceDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setMessage(message: String): MultiChoiceDialogBuilder {
        this.message = message.toSOR()
        return this
    }

    override fun setCancelable(cancelable: Boolean): MultiChoiceDialogBuilder {
        isCancelable = cancelable
        return this
    }

    override fun setBackground(resourceId: Int): MultiChoiceDialogBuilder {
        return this
    }

    override fun setSubmitTitle(title: Int): MultiChoiceDialogBuilder {
        submitButtonTitle = title.toSOR()
        return this
    }

    override fun setSubmitTitle(title: String): MultiChoiceDialogBuilder {
        submitButtonTitle = title.toSOR()
        return this
    }

    override fun setSubmitClickedListener(onClicked: OnClickedListener): MultiChoiceDialogBuilder {
        onSubmitClicked = onClicked
        return this
    }

    override fun setCancelTitle(title: Int): MultiChoiceDialogBuilder {
        cancelButtonTitle = title.toSOR()
        return this
    }

    override fun setCancelTitle(title: String): MultiChoiceDialogBuilder {
        cancelButtonTitle = title.toSOR()
        return this
    }

    override fun setCancelClickedListener(onClicked: OnClickedListener): MultiChoiceDialogBuilder {
        onCancelClicked = onClicked
        return this
    }

    override fun fromOptions(dialogId: Int): MultiChoiceDialogBuilder {
        val model = AlertDialogBuilderConfig.options.getByKey(dialogId)

        icon = model.image
        title = model.title
        message = model.message
        submitButtonTitle = model.positiveTitle
        cancelButtonTitle = model.negativeTitle
        isCancelable = model.isCancelable

        return this
    }

    override fun setInteraction(value: RecyclerAdapterInteraction): MultiChoiceDialogBuilder {
        interaction = value
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
                    interaction?.onItemClicked(position)
                    notifyItemChanged(position)
                }
                holder.isSelected(interaction?.isSelected(position) ?: false)
                interaction?.getModel(position)?.let { holder.bind(it) }
            }
        }
    }
}