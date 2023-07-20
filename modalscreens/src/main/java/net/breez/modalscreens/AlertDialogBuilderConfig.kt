package net.breez.modalscreens

import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import net.breez.modalscreens.alert.alternative.AlternativeLayoutIdSetup
import net.breez.modalscreens.alert.notification.NotificationLayoutIdSetup
import net.breez.modalscreens.alert.radio.RadioLayoutIdSetup
import net.breez.modalscreens.model.DialogModel

/**
 * Created by azamat on 19/7/23.
 */

class AlertDialogBuilderConfig {

    class Builder {
        @LayoutRes
        private var notificationLayoutId: Int? = null

        @LayoutRes
        private var alternativeLayoutId: Int? = null

        var defaultNotificationLayoutIds: NotificationLayoutIdSetup? = null
        var defaultAlternativeLayoutIds: AlternativeLayoutIdSetup? = null
        var defaultRadioLayoutIds: RadioLayoutIdSetup? = null

        var options: OptionsCollection? = null

        fun setNotificationLayoutId(layoutId: Int): Builder {
            this.notificationLayoutId = layoutId
            return this
        }

        fun setAlternativeLayoutId(layoutId: Int): Builder {
            this.alternativeLayoutId = layoutId
            return this
        }

        fun setNotificationLayoutIds(setup: NotificationLayoutIdSetup): Builder {
            this.defaultNotificationLayoutIds = setup
            return this
        }

        fun setAlternativeLayoutIdSetup(setup: AlternativeLayoutIdSetup): Builder {
            this.defaultAlternativeLayoutIds = setup
            return this
        }

        fun setRadioLayoutIdsSetup(setup: RadioLayoutIdSetup): Builder {
            this.defaultRadioLayoutIds = setup
            return this
        }

        fun build() {
            this.options = options
            this.notificationLayoutId?.let { Companion.notificationLayoutId = it }
            this.alternativeLayoutId?.let { Companion.alternativeLayoutId = it }
            this.defaultNotificationLayoutIds?.let { Companion.defaultNotificationLayoutIds = it }
            this.defaultAlternativeLayoutIds?.let { Companion.defaultAlternativeLayoutIds = it }
            this.defaultRadioLayoutIds?.let { Companion.defaultRadioLayoutIds = it }
        }

        fun options(initializer: OptionsCollection.() -> Unit): Builder {
            options = OptionsCollection().apply(initializer)
            return this
        }
    }

    companion object {
        @JvmStatic
        @LayoutRes
        var notificationLayoutId: Int = R.layout.breez_notification_dialog_layout

        @LayoutRes
        var alternativeLayoutId: Int = R.layout.breez_alternative_dialog_layout

        @LayoutRes
        var radioLayoutId: Int = R.layout.breez_radio_dialog_layout

        @DrawableRes
        var backgroundId: Int = R.drawable.default_dialog_bakground

        var defaultNotificationLayoutIds = object : NotificationLayoutIdSetup {}
        var defaultAlternativeLayoutIds = object : AlternativeLayoutIdSetup {}
        var defaultRadioLayoutIds = object : RadioLayoutIdSetup {}

        var options: OptionsCollection = OptionsCollection()

        fun newConfig(): Builder {
            return Builder()
        }
    }
}

class OptionsCollection {
    private val collection: MutableMap<Int, DialogModel> = mutableMapOf()

    fun item(id: Int, initializer: DialogModel.() -> Unit) {
        val model = DialogModel().apply(initializer)
        collection[id] = model
    }

    fun getByKey(id:Int): DialogModel = collection[id]!!
}