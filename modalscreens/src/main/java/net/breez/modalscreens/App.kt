package net.breez.modalscreens

import net.breez.modalscreens.alert.AlertDialogBuilderFactoryImpl
import net.breez.modalscreens.alert.radio.RadioDialogBuilderImpl
import net.breez.modalscreens.alert.radio.RadioViewHolder

/**
 * Created by azamat on 19/7/23.
 */

class App {

    fun use() {
        AlertDialogBuilderFactoryImpl()
            .provideRadioBuilder()
            .setInteraction(object : RadioDialogBuilderImpl.RecyclerAdapterInteraction {
                override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {

                }

                override fun getItemSize(): Int {
                    return 10
                }

                override fun isSelected(position: Int): Boolean {
                    return position == 5
                }
            })

    }
}