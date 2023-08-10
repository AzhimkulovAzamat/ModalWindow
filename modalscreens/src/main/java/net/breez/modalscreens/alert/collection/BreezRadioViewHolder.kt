package net.breez.modalscreens.alert.collection

import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 24/7/23.
 */

class BreezRadioViewHolder(private val binding: BreezRowRadioLayoutBinding) :
    RadioViewHolder(binding.root) {

    override fun bind(data: Any) {
        binding.textViewTitle.text = data as? String
    }

    override fun isSelected(selected: Boolean) {
        binding.radioButton.isChecked = selected
    }
}