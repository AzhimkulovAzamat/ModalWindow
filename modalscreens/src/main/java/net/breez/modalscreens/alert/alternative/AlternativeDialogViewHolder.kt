package net.breez.modalscreens.alert.alternative

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.breez.modalscreens.*

/**
 * Created by azamat on 1/6/23.
 */

open class AlternativeDialogViewHolder(
    delegate: CustomViewHolderDelegate = DialogBuilderPreferences.alternativeViewHolderDelegate
) :
    AlternativeDialogViewHolderContract,
    CustomViewHolderDelegate by delegate {

    private lateinit var rootView: View

    override var iconViewId = R.id.imageView_icon
    override var titleViewId = R.id.textView_title
    override var messageViewId = R.id.textView_message
    override var positiveButtonId = R.id.positiveButton
    override var negativeButtonId = R.id.negativeButton

    override fun initializeView(context: Context): AlternativeDialogViewHolderContract {
        rootView = LayoutInflater.from(context)
            .inflate(DialogBuilderPreferences.alternativeLayoutId, null, false)
        return this
    }

    override fun setupIcon(drawableId: Int): AlternativeDialogViewHolderContract {
        rootView.findViewById<ImageView>(iconViewId)?.setImageResource(drawableId)
        return this
    }

    override fun setupTitle(value: String): AlternativeDialogViewHolderContract {
        rootView.findViewById<TextView>(titleViewId)?.text = value
        return this
    }

    override fun setupMessage(value: String): AlternativeDialogViewHolderContract {
        rootView.findViewById<TextView>(messageViewId)?.text = value
        return this
    }

    override fun setupPositiveButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract {
        rootView.findViewById<TextView>(positiveButtonId)?.text = value
        rootView.findViewById<TextView>(positiveButtonId)?.setOnClickListener { onClicked() }
        return this
    }

    override fun setupNegativeButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract {
        rootView.findViewById<TextView>(negativeButtonId)?.text = value
        rootView.findViewById<TextView>(negativeButtonId)?.setOnClickListener { onClicked() }
        return this
    }

    override fun setBackground(backgroundId: Int): AlternativeDialogViewHolderContract {
        rootView.setBackgroundResource(backgroundId)
        return this
    }

    override fun getDialogView(): View {
        return rootView
    }
}