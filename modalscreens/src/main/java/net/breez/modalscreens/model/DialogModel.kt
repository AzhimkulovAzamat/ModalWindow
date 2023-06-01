package net.breez.modalscreens.model

/**
 * Created by azamat on 6/3/23.
 */

data class DialogModel(
    val image: Int,
    val title: StringOrResource,
    val positiveTitle: StringOrResource,
    val isCancelable: Boolean,
    val message: StringOrResource? = null,
    val negativeTitle: StringOrResource? = null,
)
