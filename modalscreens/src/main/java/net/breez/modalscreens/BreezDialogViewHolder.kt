package net.breez.modalscreens

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.breez.modalscreens.model.DialogType

/**
 * Created by azamat on 23/12/22.
 */

class BreezDialogViewHolder(
    val dialogType: DialogType,
    delegate: CustomViewHolderDelegate
) :
    DialogViewHolderContract,
    CustomViewHolderDelegate by delegate {

    private lateinit var rootView: View

    override fun initializeView(context: Context): DialogViewHolderContract {
        rootView = LayoutInflater.from(context)
            .inflate(dialogType.getLayoutId(), null, false)
        return this
    }

    override fun setupIcon(drawableId: Int): DialogViewHolderContract {
        rootView.findViewById<ImageView>(R.id.imageView_icon)?.setImageResource(drawableId)
        return this
    }

    override fun setupTitle(value: String): DialogViewHolderContract {
        rootView.findViewById<TextView>(R.id.textView_title)?.text = value
        return this
    }

    override fun setupMessage(value: String): DialogViewHolderContract {
        rootView.findViewById<TextView>(R.id.textView_message)?.text = value
        return this
    }

    override fun setupPositiveButton(
        value: String,
        onClicked: () -> Unit
    ): DialogViewHolderContract {
        rootView.findViewById<TextView>(R.id.positiveButton)?.text = value
        rootView.findViewById<TextView>(R.id.positiveButton)?.setOnClickListener { onClicked() }
        return this
    }

    override fun setupNegativeButton(
        value: String,
        onClicked: () -> Unit
    ): DialogViewHolderContract {
        rootView.findViewById<TextView>(R.id.negativeButton)?.apply {
            text = value
            visibility = View.VISIBLE
            setOnClickListener { onClicked() }
        }
        return this
    }

    override fun getDialogView(): View {
        return rootView
    }

    override fun setBackground(backgroundId: Int) {
        rootView.setBackgroundResource(backgroundId)
    }
}