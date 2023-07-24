package net.breez.modalscreens.alert.radio

import android.widget.RadioButton
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 24/7/23.
 */

class BreezRadioViewHolder(val binding: BreezRowRadioLayoutBinding) : RadioViewHolder(binding.root) {

    override fun isSelected(selected: Boolean) {
        binding.radioButton.isChecked = selected
    }

    override fun getRadioView(): RadioButton {
        return binding.radioButton
    }
}