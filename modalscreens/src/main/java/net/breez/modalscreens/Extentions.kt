package net.breez.modalscreens

import net.breez.modalscreens.model.StringOrResource

/**
 * Created by azamat on 20/7/23.
 */

fun String.toSOR(): StringOrResource {
    return StringOrResource(this)
}

fun Int.toSOR(): StringOrResource {
    return StringOrResource(this)
}