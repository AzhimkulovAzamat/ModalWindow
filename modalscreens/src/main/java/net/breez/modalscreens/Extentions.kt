package net.breez.modalscreens

import android.content.Context

/**
 * Created by azamat on 20/7/23.
 */

fun Int.dp(context: Context): Float {
    return this * context.resources.displayMetrics.density
}