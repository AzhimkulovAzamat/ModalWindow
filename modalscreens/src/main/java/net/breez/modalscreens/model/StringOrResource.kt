package net.breez.modalscreens.model

import android.content.Context

/**
 * Created by azamat on 23/12/22.
 */

data class StringOrResource internal constructor(
    private val value:String?,
    private val resourceId:Int?
) {
    constructor(value: String): this(value, null)
    constructor(resourceId: Int): this(null, resourceId)

    fun getString(context: Context): String {
        if (value != null) return value
        if (resourceId != null) return context.getString(resourceId)

        throw IllegalArgumentException("Use ony public constructor")
    }
}
