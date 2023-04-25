package net.breez.modalscreens.model

import net.breez.modalscreens.DialogBuilderPreferences

/**
 * Created by azamat on 25/4/23.
 */

enum class DialogType {
    ALTERNATIVE,
    NOTIFICATION;

    fun getLayoutId(): Int {
        return when(this) {
            ALTERNATIVE -> DialogBuilderPreferences.alternativeLayoutId
            NOTIFICATION -> DialogBuilderPreferences.notificationLayoutId
        }
    }
}