package net.breez.modalscreens

import android.view.LayoutInflater
import android.view.ViewGroup
import net.breez.modalscreens.alert.AlertDialogBuilderFactoryImpl
import net.breez.modalscreens.alert.radio.BreezRadioViewHolder
import net.breez.modalscreens.alert.radio.RadioViewHolder
import net.breez.modalscreens.databinding.BreezRowRadioLayoutBinding

/**
 * Created by azamat on 19/7/23.
 */

class App {
    fun use() {
        AlertDialogBuilderFactoryImpl()
            .provideRadioBuilder()
            .setTitle("Test of radio")
            .setMessage("Choose of some")
            .setAdapter(object : RadioDialogRVAdapter() {
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
                    val binding = BreezRowRadioLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                    return BreezRadioViewHolder(binding)
                }

                override fun getItemCount(): Int {
                    return 10
                }

                override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
                    (holder as? BreezRadioViewHolder)?.select()
                }
            })
    }
}