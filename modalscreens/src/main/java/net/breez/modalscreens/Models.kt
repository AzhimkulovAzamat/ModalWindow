package net.breez.modalscreens

import android.content.Context
import android.view.View
import androidx.annotation.StringRes

internal data class DialogString internal constructor(
    private val value:String?,
    private val resourceId:Int?
) {
    constructor(value: String): this(value, null)
    constructor(@StringRes resourceId: Int): this(null, resourceId)

    fun getString(context: Context): String {
        if (value != null) return value
        if (resourceId != null) return context.getString(resourceId)

        throw IllegalArgumentException("Use ony public constructor")
    }
}

internal data class ButtonSetup(
    val title:DialogString,
    val action: (View) -> Boolean
)