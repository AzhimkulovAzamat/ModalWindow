package net.breez.modalscreens.snackbar

import android.view.Gravity
import net.breez.modalscreens.Padding

/**
 * Created by azamat on 28/7/23.
 */

class SnackbarBuilderConfig {

    class Builder {

        var options: OptionsCollection? = null
        var gravity: Int? = null
        var padding: Padding? = null
        var viewHolder:SnackbarViewHolder? = null

        fun options(initializer: OptionsCollection.() -> Unit): Builder {
            options = OptionsCollection().apply(initializer)
            return this
        }

        fun setGravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }

        fun setPadding(padding: Padding): Builder {
            this.padding = padding
            return this
        }

        fun setViewHolder(viewHolder: SnackbarViewHolder): Builder {
            this.viewHolder = viewHolder
            return this
        }

        fun build() {
            this.options?.let { SnackbarBuilderConfig.options = it }
            this.gravity?.let { SnackbarBuilderConfig.gravity = it }
            this.padding?.let { SnackbarBuilderConfig.padding = it }
            this.viewHolder?.let { SnackbarBuilderConfig.viewHolder = it }
        }
    }

    companion object {
        var options: OptionsCollection = OptionsCollection()
        var gravity: Int = Gravity.TOP
        var padding: Padding = Padding(4, 100, 10, 0)
        var viewHolder: SnackbarViewHolder = SimpleSnackbarViewHolder()
    }
}

class OptionsCollection {
    private val collection: MutableMap<Int, SnackbarModel> = mutableMapOf()

    fun item(id: Int, snackbarModel: SnackbarModel) {
        collection[id] = snackbarModel
    }

    fun items(mMap: MutableMap<Int, SnackbarModel>) {
        collection.putAll(mMap)
    }

    fun getByKey(id: Int): SnackbarModel = collection[id]!!
}