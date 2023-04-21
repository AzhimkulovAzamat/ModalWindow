package net.breez.modalscreens

import android.content.Context
import android.widget.Toast

/**
 * Created by azamat on 21/4/23.
 */

class MyAlertDialogTest {
    fun test(context: Context, message:String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}