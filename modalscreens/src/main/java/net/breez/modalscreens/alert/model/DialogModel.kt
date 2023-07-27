package net.breez.modalscreens.alert.model

import androidx.annotation.DrawableRes
import net.breez.modalscreens.StringOrResource

/**
 * Created by azamat on 6/3/23.
 */
class DialogModel {
    var image: Int? = null
    var title: StringOrResource? = null
    var positiveTitle: StringOrResource? = null
    var isCancelable: Boolean = true
    var message: StringOrResource? = null
    var negativeTitle: StringOrResource? = null

    fun setImage(@DrawableRes image: Int) {
        this.image = image
    }

    fun setHead(title: StringOrResource, message: StringOrResource? = null) {
        this.title = title
        this.message = message
    }

    fun setPositiveButton(title: StringOrResource) {
        positiveTitle = title
    }

    fun setNegativeButton(title: StringOrResource) {
        negativeTitle = title
    }

    fun setAdditional(isCancelable: Boolean) {
        this.isCancelable = isCancelable
    }
}