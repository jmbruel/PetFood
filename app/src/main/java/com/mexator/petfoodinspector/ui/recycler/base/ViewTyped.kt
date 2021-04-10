package com.mexator.petfoodinspector.ui.recycler.base

/**
 * @author Anton Brisilin a.brisilin@innopolis.university
 */

/**
 * Abstract content that can be submitted to [BaseAdapter] to
 * be displayed with RecyclerView
 */
interface ViewTyped {
    /**
     * Unique id of list item. Used to differentiate items with DiffUtil
     */
    val uid: Int

    /**
     * [viewType] gives a factory for view holders hint about which ViewHolder
     * should be created for this item.
     * In the vast majority of cases **id of layout resource for item** is used
     * as a [viewType]
     */
    val viewType: Int
}