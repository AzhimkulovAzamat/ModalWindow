package net.breez.modalscreens

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes

/**
 * Created by azamat on 9/8/23.
 */

class ModalWindowConfig private constructor() {

    class Builder {
        @LayoutRes
        private var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout

        @LayoutRes
        private var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout

        @LayoutRes
        private var radioLayoutId: Int = R.layout.breez_radio_dialog_layout

        @LayoutRes
        private var checkboxLayoutId: Int = R.layout.breez_radio_dialog_layout

        @LayoutRes
        private var snackbarLayoutId: Int = R.layout.breez_snackbar_layout

        fun setNotificationLayoutId(layoutId: Int): Builder {
            this.notificationLayoutId = layoutId
            return this
        }

        fun setAlternativeLayoutId(layoutId: Int): Builder {
            this.alternativeLayoutId = layoutId
            return this
        }

//        fun setRadioLayoutId(layoutId: Int): Builder {
//            this.radioLayoutId = layoutId
//            return this
//        }
//
//        fun setCheckboxLayoutId(layoutId: Int): Builder {
//            this.checkboxLayoutId = layoutId
//            return this
//        }

        fun setSnackbarLayoutId(layoutId: Int): Builder {
            this.snackbarLayoutId = layoutId
            return this
        }

        fun build(context: Context) {
            testNotificationLayout(context)
            testAlternativeLayout(context)
//            testRadioLayout(context)
//            testCheckboxLayout(context)
            testSnackbarLayout(context)

            Companion.notificationLayoutId = notificationLayoutId
            Companion.alternativeLayoutId = alternativeLayoutId
            Companion.radioLayoutId = radioLayoutId
            Companion.checkboxLayoutId = checkboxLayoutId
            Companion.snackbarLayoutId = snackbarLayoutId
        }

        private fun testSnackbarLayout(context: Context) {
            val layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(snackbarLayoutId, null)

            val rootLayout = layout.findViewById<View>(R.id.rootLayout)
            val imageViewLogo = layout.findViewById<View>(R.id.imageView_logo)
            val textViewTitle = layout.findViewById<View>(R.id.textView_title)
            val imageViewClose = layout.findViewById<View>(R.id.imageView_close)

            if (rootLayout == null) {
                throw IllegalStateException("View with ID R.id.rootLayout not found in the snackbar layout")
            }

            if (imageViewLogo == null) {
                throw IllegalStateException("View with ID R.id.imageView_logo not found in the snackbar layout")
            }

            if (textViewTitle == null) {
                throw IllegalStateException("View with ID R.id.textView_title not found in the snackbar layout")
            }

            if (imageViewClose == null) {
                throw IllegalStateException("View with ID R.id.imageView_close not found in the snackbar layout")
            }

        }

        private fun testCheckboxLayout(context: Context) {
            val layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(radioLayoutId, null)

            val imageViewIcon = layout.findViewById<View>(R.id.imageView_icon)
            val textViewTitle = layout.findViewById<View>(R.id.textView_title)
            val textViewMessage = layout.findViewById<View>(R.id.textView_message)
            val recyclerView = layout.findViewById<View>(R.id.recyclerView_radioAlert)
            val positiveButton = layout.findViewById<View>(R.id.positiveButton)
            val negativeButton = layout.findViewById<View>(R.id.negativeButton)

            if (imageViewIcon == null) {
                throw IllegalStateException(
                    "View with ID R.id.imageView_icon not found in " +
                            "the checkbox alert dialog layout"
                )
            }

            if (textViewTitle == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_title not found in " +
                            "the checkbox alert dialog layout"
                )
            }

            if (textViewMessage == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_message not found in " +
                            "the checkbox alert dialog layout"
                )
            }

            if (recyclerView == null) {
                throw IllegalStateException(
                    "View with ID R.id.recyclerView_radioAlert not found in" +
                            " the checkbox alert dialog layout"
                )
            }

            if (positiveButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.positiveButton not found in the " +
                            "checkbox alert dialog layout"
                )
            }

            if (negativeButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.negativeButton not found in the " +
                            "checkbox alert dialog layout"
                )
            }
        }

        private fun testRadioLayout(context: Context) {
            val layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(radioLayoutId, null)

            val imageViewIcon = layout.findViewById<View>(R.id.imageView_icon)
            val textViewTitle = layout.findViewById<View>(R.id.textView_title)
            val textViewMessage = layout.findViewById<View>(R.id.textView_message)
            val recyclerView = layout.findViewById<View>(R.id.recyclerView_radioAlert)
            val positiveButton = layout.findViewById<View>(R.id.positiveButton)
            val negativeButton = layout.findViewById<View>(R.id.negativeButton)

            if (imageViewIcon == null) {
                throw IllegalStateException(
                    "View with ID R.id.imageView_icon not found in " +
                            "the radio alert dialog layout"
                )
            }

            if (textViewTitle == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_title not found in " +
                            "the radio alert dialog layout"
                )
            }

            if (textViewMessage == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_message not found in " +
                            "the radio alert dialog layout"
                )
            }

            if (recyclerView == null) {
                throw IllegalStateException(
                    "View with ID R.id.recyclerView_radioAlert not found in" +
                            " the radio alert dialog layout"
                )
            }

            if (positiveButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.positiveButton not found in the " +
                            "radio alert dialog layout"
                )
            }

            if (negativeButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.negativeButton not found in the " +
                            "radio alert dialog layout"
                )
            }
        }

        private fun testAlternativeLayout(context: Context) {
            val layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(alternativeLayoutId, null)

            val imageViewIcon = layout.findViewById<View>(R.id.imageView_icon)
            val textViewTitle = layout.findViewById<View>(R.id.textView_title)
            val textViewMessage = layout.findViewById<View>(R.id.textView_message)
            val positiveButton = layout.findViewById<View>(R.id.positiveButton)
            val negativeButton = layout.findViewById<View>(R.id.negativeButton)

            if (imageViewIcon == null) {
                throw IllegalStateException(
                    "View with ID R.id.imageView_icon not found in the " +
                            "alternative alert dialog layout"
                )
            }

            if (textViewTitle == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_title not found in the " +
                            "alternative alert dialog layout"
                )
            }

            if (textViewMessage == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_message not found in the " +
                            "alternative alert dialog layout"
                )
            }

            if (positiveButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.positiveButton not found in the " +
                            "alternative alert dialog layout"
                )
            }

            if (negativeButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.negativeButton not found in the " +
                            "alternative alert dialog layout"
                )
            }
        }

        private fun testNotificationLayout(context: Context) {
            val layout = LayoutInflater.from(context).inflate(notificationLayoutId, null)

            val imageViewIcon = layout.findViewById<View>(R.id.imageView_icon)
            val textViewTitle = layout.findViewById<View>(R.id.textView_title)
            val textViewMessage = layout.findViewById<View>(R.id.textView_message)
            val positiveButton = layout.findViewById<View>(R.id.positiveButton)

            if (imageViewIcon == null) {
                throw IllegalStateException(
                    "View with ID R.id.imageView_icon not found in the " +
                            "notification alert dialog layout"
                )
            }

            if (textViewTitle == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_title not found in the " +
                            "notification alert dialog layout"
                )
            }

            if (textViewMessage == null) {
                throw IllegalStateException(
                    "View with ID R.id.textView_message not found in the " +
                            "notification alert dialog layout"
                )
            }

            if (positiveButton == null) {
                throw IllegalStateException(
                    "View with ID R.id.positiveButton not found in the " +
                            "notification alert dialog layout"
                )
            }
        }
    }

    companion object {
        @JvmStatic
        @LayoutRes
        internal var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout

        @LayoutRes
        internal var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout

        @LayoutRes
        internal var radioLayoutId: Int = R.layout.breez_radio_dialog_layout

        @LayoutRes
        internal var checkboxLayoutId: Int = R.layout.breez_radio_dialog_layout

        @LayoutRes
        internal var snackbarLayoutId: Int = R.layout.breez_snackbar_layout

        internal var dialogTypeDriver: DialogTypeDriver? = null

        fun newConfig(): Builder {
            return Builder()
        }
    }

    interface DialogTypeDriver {
        fun obtain(view: View, modalType: ModalType)
    }
}