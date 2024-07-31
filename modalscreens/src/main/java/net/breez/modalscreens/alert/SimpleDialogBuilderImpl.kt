package net.breez.modalscreens.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AlertDialog
import net.breez.modalscreens.ButtonSetup
import net.breez.modalscreens.DialogString
import net.breez.modalscreens.ModalType
import net.breez.modalscreens.ModalWindowConfig

class SimpleDialogBuilderImpl : BaseDialogBuilder(), SimpleDialogBuilder {

    private var dialogType: ModalType = ModalType.NOTIFICATION
    private var settings: SimpleDialogSettings = SimpleDialogSettings()

    override fun setIcon(iconRes: Int): SimpleDialogBuilder {
        settings = settings.copy(icon = iconRes)
        return this
    }

    override fun setTitle(titleRes: Int): SimpleDialogBuilder {
        settings = settings.copy(title = DialogString(titleRes))
        return this
    }

    override fun setTitle(title: String): SimpleDialogBuilder {
        settings = settings.copy(title = DialogString(title))
        return this
    }

    override fun setMessage(messageRes: Int): SimpleDialogBuilder {
        settings = settings.copy(message = DialogString(messageRes))
        return this
    }

    override fun setMessage(message: String): SimpleDialogBuilder {
        settings = settings.copy(message = DialogString(message))
        return this
    }

    override fun setPositiveButton(titleRes: Int, action: (View) -> Boolean): SimpleDialogBuilder {
        settings = settings.copy(positiveSetup = ButtonSetup(DialogString(titleRes), action))
        return this
    }

    override fun setPositiveButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder {
        settings = settings.copy(positiveSetup = ButtonSetup(DialogString(title), action))
        return this
    }

    override fun setNegativeButton(titleInt: Int, action: (View) -> Boolean): SimpleDialogBuilder {
        settings = settings.copy(negativeSetup = ButtonSetup(DialogString(titleInt), action))
        this.dialogType = ModalType.ALTERNATIVE
        return this
    }

    override fun setNegativeButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder {
        settings = settings.copy(negativeSetup = ButtonSetup(DialogString(title), action))
        this.dialogType = ModalType.ALTERNATIVE
        return this
    }

//    override fun setNeutralButton(titleRes: Int, action: (View) -> Boolean): SimpleDialogBuilder {
//        settings = settings.copy(neutralSetup = ButtonSetup(DialogString(titleRes), action))
//        this.dialogType = ModalType.ALTERNATIVE
//        return this
//    }
//
//    override fun setNeutralButton(title: String, action: (View) -> Boolean): SimpleDialogBuilder {
//        settings = settings.copy(neutralSetup = ButtonSetup(DialogString(title), action))
//        this.dialogType = ModalType.ALTERNATIVE
//        return this
//    }

    override fun setCancelable(isCancelable: Boolean): SimpleDialogBuilder {
        settings = settings.copy(isCancelable = isCancelable)
        return this
    }

    override fun bind(view: View, dialog: AlertDialog) {
        provideInflater(dialogType).inflate(view, settings) { dialog.dismiss() }
        dialog.setCancelable(settings.isCancelable)
    }

    override fun provideLayout(context: Context, modalType: ModalType?): View {
        modalType?.let { dialogType = it }
        val view = LayoutInflater.from(context)
            .inflate(getLayoutResource(dialogType), null, false)
        ModalWindowConfig.dialogTypeDriver?.obtain(view, dialogType)
        return view
    }

    private fun getLayoutResource(modalType: ModalType): Int {
        return when (modalType) {
            ModalType.NOTIFICATION -> ModalWindowConfig.notificationLayoutId
            ModalType.ALTERNATIVE -> ModalWindowConfig.alternativeLayoutId
        }
    }

    private fun provideInflater(modalType: ModalType): DialogInflater {
        return when (modalType) {
            ModalType.NOTIFICATION -> NotificationDialogInflater()
            ModalType.ALTERNATIVE -> AlternativeDialogInflater()
        }
    }
}

internal data class SimpleDialogSettings(
    @DrawableRes
    val icon: Int? = null,
    val title: DialogString? = null,
    val message: DialogString? = null,
    val positiveSetup: ButtonSetup? = null,
    val negativeSetup: ButtonSetup? = null,
    val neutralSetup: ButtonSetup? = null,
    val isCancelable: Boolean = true
)