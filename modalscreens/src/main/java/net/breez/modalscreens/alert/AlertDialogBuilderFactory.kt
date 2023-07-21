package net.breez.modalscreens.alert

import net.breez.modalscreens.alert.alternative.AlternativeDialogBuilder
import net.breez.modalscreens.alert.notification.NotificationDialogBuilder
import net.breez.modalscreens.alert.radio.RadioDialogBuilder

/**
 * Created by azamat on 21/7/23.
 */

interface AlertDialogBuilderFactory {

    fun provideNotificationBuilder(): NotificationDialogBuilder

    fun provideAlternativeBuilder(): AlternativeDialogBuilder

    fun provideRadioBuilder(): RadioDialogBuilder
}