package net.breez.modalscreens.snackbar

import android.view.View
import androidx.annotation.LayoutRes
import net.breez.modalscreens.R
import net.breez.modalscreens.StringOrResource
import net.breez.modalscreens.databinding.BreezSnackbarLayoutBinding

/**
 * Created by azamat on 31/7/23.
 */

abstract class SnackbarViewHolder(@LayoutRes val layoutId: Int) {

    abstract fun bind(view: View, snackbarModel: SnackbarModel?, dismiss: () -> Unit)
}

class SimpleSnackbarViewHolder :
    SnackbarViewHolder(R.layout.breez_snackbar_layout) {

    override fun bind(view: View, snackbarModel: SnackbarModel?, dismiss: () -> Unit) {
        val binding = BreezSnackbarLayoutBinding.bind(view)
        binding.textViewTitle.text = snackbarModel?.message?.getString(view.context)
        snackbarModel?.icon?.let { binding.imageViewLogo.setImageResource(it) }
        snackbarModel?.closeIcon?.let {
            binding.imageViewClose.visibility = View.VISIBLE
            binding.imageViewClose.setImageResource(it)
            binding.imageViewClose.setOnClickListener { dismiss() }
        }
    }
}