package net.breez.modalscreens.alert.collection.checkbox

import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.CallSuper
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.breez.modalscreens.*
import net.breez.modalscreens.alert.collection.RadioViewHolder

/**
 * Created by azamat on 7/8/23.
 */

//class CheckboxDialogBuilderImpl : BaseDialogBuilder(), CheckboxDialogBuilder {
//
//    @DrawableRes
//    private var icon: Int? = null
//    private var title: StringOrResource? = null
//    private var message: StringOrResource? = null
//    private var positiveButtonTitle: StringOrResource? = null
//    private var negativeButtonTitle: StringOrResource? = null
//
//    private var positiveButtonClickListener:OnClickedListener? = null
//    private var negativeButtonClickListener:OnClickedListener? = null
//
//    private var isCancelable: Boolean = true
//    private var interaction: CheckboxDialogBuilder.RecyclerAdapterInteraction? = null
//    override val layoutRes: Int
//        get() = ModalWindowConfig.checkboxLayoutId
//
//    override fun setIcon(iconRes: Int): CheckboxDialogBuilder {
//        icon = iconRes
//        return this
//    }
//
//    override fun setTitle(title: Int): CheckboxDialogBuilder {
//        this.title = title.toSOR()
//        return this
//    }
//
//    override fun setTitle(title: String): CheckboxDialogBuilder {
//        this.title = title.toSOR()
//        return this
//    }
//
//    override fun setMessage(message: Int): CheckboxDialogBuilder {
//        this.message = message.toSOR()
//        return this
//    }
//
//    override fun setMessage(message: String): CheckboxDialogBuilder {
//        this.message = message.toSOR()
//        return this
//    }
//
//    override fun setNegativeButtonTitle(title: Int): CheckboxDialogBuilder {
//        this.negativeButtonTitle = title.toSOR()
//        return this
//    }
//
//    override fun setNegativeButtonTitle(title: String): CheckboxDialogBuilder {
//        this.negativeButtonTitle = title.toSOR()
//        return this
//    }
//
//    override fun setPositiveButtonTitle(title: Int): CheckboxDialogBuilder {
//        this.positiveButtonTitle = title.toSOR()
//        return this
//    }
//
//    override fun setPositiveButtonTitle(title: String): CheckboxDialogBuilder {
//        this.positiveButtonTitle = title.toSOR()
//        return this
//    }
//
//    override fun setPositiveClickListener(listener: OnClickedListener): CheckboxDialogBuilder {
//        this.positiveButtonClickListener = listener
//        return this
//    }
//
//    override fun setNegativeClickListener(listener: OnClickedListener): CheckboxDialogBuilder {
//        this.negativeButtonClickListener = listener
//        return this
//    }
//
//    override fun setCancelable(isCancelable: Boolean): CheckboxDialogBuilder {
//        this.isCancelable = isCancelable
//        return this
//    }
//
//    override fun setInteraction(value: CheckboxDialogBuilder.RecyclerAdapterInteraction): CheckboxDialogBuilderImpl {
//        interaction = value
//        return this
//    }
//
//    @CallSuper
//    override fun bind(view: View, dialog: AlertDialog) {
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView_radioAlert)
//        val textViewTitle = view.findViewById<TextView>(R.id.textView_title)
//        val textViewMessage = view.findViewById<TextView>(R.id.textView_message)
//        val positiveButton = view.findViewById<Button>(R.id.positiveButton)
//        val negativeButton = view.findViewById<Button>(R.id.negativeButton)
//        val imageViewIcon = view.findViewById<ImageView>(R.id.imageView_icon)
//
//        textViewTitle.text = title?.getString(view.context)
//        textViewMessage.text = message?.getString(view.context)
//        positiveButtonTitle?.let {
//            positiveButton.text = it.getString(view.context)
//            positiveButton.visibility = View.VISIBLE
//        }
//        negativeButtonTitle?.let {
//            negativeButton.text = it.getString(view.context)
//            negativeButton.visibility = View.VISIBLE
//        }
//        positiveButton.setOnClickListener {
//            positiveButtonClickListener?.invoke()
//            dialog.dismiss()
//        }
//        negativeButton.setOnClickListener {
//            negativeButtonClickListener?.invoke()
//            dialog.dismiss()
//        }
//        icon?.let { imageViewIcon.setImageResource(it) }
//        dialog.setCancelable(isCancelable)
//
//        setupRecyclerView(recyclerView)
//    }
//
//    private fun setupRecyclerView(
//        recycler: RecyclerView
//    ) {
//        recycler.layoutManager =
//            LinearLayoutManager(recycler.context, LinearLayoutManager.VERTICAL, false)
//        recycler.adapter = object : RecyclerView.Adapter<RadioViewHolder>() {
//
//            override fun onCreateViewHolder(
//                parent: ViewGroup,
//                viewType: Int
//            ): RadioViewHolder {
//                return interaction!!.onCreateViewHolder(parent)
//            }
//
//            override fun getItemCount(): Int = interaction?.getItemSize() ?: 0
//
//            override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
//                holder.itemView.setOnClickListener {
//                    interaction?.onItemClicked(position)
//                    notifyItemChanged(position)
//                }
//                holder.isSelected(interaction?.isSelected(position) ?: false)
//                interaction?.getModel(position)?.let { holder.bind(it) }
//            }
//        }
//    }
//}