package net.breez.modalscreens.alert.radio

import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 24/7/23.
 */

class BreezRadioViewHolder(val binding: BreezRowRadioLayoutBinding) :
    RadioViewHolder(binding.root) {

    override fun select() {
        binding.radioButton.isChecked = true
    }

    override fun deselect() {
        binding.radioButton.isChecked = false
    }
}