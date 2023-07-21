package net.breez.modalscreens.alert

import net.breez.modalscreens.alert.alternative.AlternativeDialogBuilder
import net.breez.modalscreens.alert.alternative.AlternativeDialogBuilderImpl
import net.breez.modalscreens.alert.notification.NotificationDialogBuilder
import net.breez.modalscreens.alert.notification.NotificationDialogBuilderImpl
import net.breez.modalscreens.alert.radio.RadioDialogBuilder
import net.breez.modalscreens.alert.radio.RadioDialogBuilderImpl

/**
 * Created by azamat on 21/7/23.
 */

class AlertDialogBuilderFactoryImpl:AlertDialogBuilderFactory {

    override fun provideNotificationBuilder(): NotificationDialogBuilder {
        return NotificationDialogBuilderImpl()
    }

    override fun provideAlternativeBuilder(): AlternativeDialogBuilder {
        return AlternativeDialogBuilderImpl()
    }

    override fun provideRadioBuilder(): RadioDialogBuilder {
        return RadioDialogBuilderImpl()
    }
}