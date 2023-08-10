package net.breez.modalscreens.alert.collection.radio

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.breez.modalscreens.ModalWindowConfig
import net.breez.modalscreens.R
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.alert.BaseDialogBuilder
import net.breez.modalscreens.alert.collection.RadioViewHolder
import net.breez.modalscreens.toSOR

/**
 * Created by azamat on 7/8/23.
 */

class RadioDialogBuilderImpl<T> : BaseDialogBuilder(), RadioDialogBuilder<T> {

    @DrawableRes
    private var icon: Int? = null
    private var title: StringOrResource? = null
    private var message: StringOrResource? = null
    private var positiveButtonTitle: StringOrResource? = null
    private var negativeButtonTitle: StringOrResource? = null
    private var isCancelable: Boolean = true
    private var interaction: RadioDialogBuilder.RecyclerAdapterInteraction<T>? = null
    private var selectedPosition: Int? = null
    override val layoutRes: Int
        get() = ModalWindowConfig.radioLayoutId

    override fun setIcon(iconRes: Int): RadioDialogBuilder<T> {
        icon = iconRes
        return this
    }

    override fun setTitle(title: Int): RadioDialogBuilder<T> {
        this.title = title.toSOR()
        return this
    }

    override fun setTitle(title: String): RadioDialogBuilder<T> {
        this.title = title.toSOR()
        return this
    }

    override fun setMessage(message: Int): RadioDialogBuilder<T> {
        this.message = message.toSOR()
        return this
    }

    override fun setMessage(message: String): RadioDialogBuilder<T> {
        this.message = message.toSOR()
        return this
    }

    override fun setNegativeButtonTitle(title: Int): RadioDialogBuilder<T> {
        this.negativeButtonTitle = title.toSOR()
        return this
    }

    override fun setNegativeButtonTitle(title: String): RadioDialogBuilder<T> {
        this.negativeButtonTitle = title.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: Int): RadioDialogBuilder<T> {
        this.positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setPositiveButtonTitle(title: String): RadioDialogBuilder<T> {
        this.positiveButtonTitle = title.toSOR()
        return this
    }

    override fun setCancelable(isCancelable: Boolean): RadioDialogBuilder<T> {
        this.isCancelable = isCancelable
        return this
    }

    override fun setInteraction(value: RadioDialogBuilder.RecyclerAdapterInteraction<T>): RadioDialogBuilder<T> {
        interaction = value
        return this
    }

    override fun bind(view: View, dialog: AlertDialog) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_radioAlert)
        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
        val negativeButton = view.findViewById<Button>(R.id.negativeButton)
        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)

        textViewTitle.text = title?.getString(view.context)
        textViewMessage.text = message?.getString(view.context)
        positiveButtonTitle?.let {
            positiveButton.text = it.getString(view.context)
            positiveButton.visibility = View.VISIBLE
        }
        negativeButtonTitle?.let {
            negativeButton.text = it.getString(view.context)
            negativeButton.visibility = View.VISIBLE
        }
        icon?.let { imageViewIcon.setImageResource(it) }
        dialog.setCancelable(isCancelable)

        setupRecyclerView(recyclerView, dialog)
    }

    private fun setupRecyclerView(
        recycler: RecyclerView,
        alertDialog: AlertDialog
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
                    if (positiveButtonTitle == null) {
                        alertDialog.dismiss()
                    }
                }
                holder.isSelected(selectedPosition == position)
                interaction?.getModel(position)?.let { holder.bind(it) }
            }
        }
    }
}