package net.breez.modalscreens

data class Margins(
    val start: Int = 0,
    val top: Int = 27,
    val end: Int = 0,
    val bottom: Int = 0
) {
    constructor(margin: Int) : this(margin, margin, margin, margin)

    companion object {
        fun horizontal(margin: Int): Margins = Margins(start = margin, end = margin)
        fun vertical(margin: Int): Margins = Margins(top = margin, bottom = margin)
    }

    fun horizontal(margin: Int): Margins = this.copy(start = margin, end = margin)
    fun vertical(margin: Int): Margins = Margins(top = margin, bottom = margin)
}