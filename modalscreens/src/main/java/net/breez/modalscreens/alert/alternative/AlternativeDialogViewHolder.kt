package net.breez.modalscreens.alert.alternative

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import net.breez.modalscreens.AlternativeDialogViewHolderContract
import net.breez.modalscreens.DialogBuilderPreferences

/**
 * Created by azamat on 1/6/23.
 */

open class AlternativeDialogViewHolder(alternativeLayoutIdSetup: AlternativeLayoutIdSetup) :
    AlternativeDialogViewHolderContract, AlternativeLayoutIdSetup by alternativeLayoutIdSetup {

    private lateinit var rootView: View

    private val iconView: ImageView by lazy { getViewById(iconViewId) }
    private val titleView: TextView by lazy { getViewById(titleViewId) }
    private val messageView: TextView by lazy { getViewById(messageViewId) }
    private val positiveButton: TextView by lazy { getViewById(positiveButtonId) }
    private val negativeButton: TextView by lazy { getViewById(negativeButtonId) }

    override fun initializeView(context: Context): AlternativeDialogViewHolderContract {
        rootView = LayoutInflater.from(context)
            .inflate(DialogBuilderPreferences.alternativeLayoutId, null, false)
        return this
    }

    override fun setupIcon(drawableId: Int): AlternativeDialogViewHolderContract {
        iconView.setImageResource(drawableId)
        return this
    }

    override fun setupTitle(value: String): AlternativeDialogViewHolderContract {
        titleView.text = value
        return this
    }

    override fun setupMessage(value: String): AlternativeDialogViewHolderContract {
        messageView.text = value
        return this
    }

    override fun setupPositiveButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract {
        positiveButton.text = value
        positiveButton.setOnClickListener { onClicked() }
        return this
    }

    override fun setupNegativeButton(
        value: String,
        onClicked: () -> Unit
    ): AlternativeDialogViewHolderContract {
        negativeButton.text = value
        negativeButton.setOnClickListener { onClicked() }
        return this
    }

    override fun setBackground(backgroundId: Int): AlternativeDialogViewHolderContract {
        rootView.setBackgroundResource(backgroundId)
        return this
    }

    override fun getDialogView(): View {
        return rootView
    }

    private fun <T : View> getViewById(resourceId: Int): T {
        return rootView.findViewById(resourceId)
    }
}