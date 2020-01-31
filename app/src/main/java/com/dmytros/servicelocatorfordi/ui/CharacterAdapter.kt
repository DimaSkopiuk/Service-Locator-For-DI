package com.dmytros.servicelocatorfordi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmytros.servicelocatorfordi.R
import com.dmytros.servicelocatorfordi.data.MarvelCharacter
import kotlin.properties.Delegates

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var items: List<MarvelCharacter> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_character, parent, false)
        .let { ViewHolder(it) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].apply {
            holder.caption.text = name
        }
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        val caption: TextView = root.findViewById(R.id.caption)
        val image: ImageView = root.findViewById(R.id.image)
    }
}