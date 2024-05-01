package net.breez.modalscreens

data class Margins(
    val start: Int,
    val top: Int,
    val end: Int,
    val bottom: Int
) {
    constructor(margin: Int) : this(margin, margin, margin, margin)

    companion object {

        fun horizontal(margin: Int): Margins = Margins(margin, 0, margin, 0)
        fun vertical(margin: Int): Margins = Margins(0, margin, 0, margin)
    }

    fun horizontal(margin: Int): Margins = Margins(margin, top, margin, bottom)
    fun vertical(margin: Int): Margins = Margins(start, margin, end, margin)
}