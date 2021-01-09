package com.arifahmadalfian.academies.ui.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arifahmadalfian.academies.data.source.local.entity.ModuleEntity
import com.arifahmadalfian.academies.databinding.ItemsModuleListCustomBinding
import java.util.*

class ModuleListAdapter internal constructor(
        private val listener: IMyAdapterClickListener
): RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {


    private val listModules = ArrayList<ModuleEntity>()

    inner class ModuleViewHolder(private val binding: ItemsModuleListCustomBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModuleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, listModules[holder.adapterPosition].moduleId)
        }
    }

    override fun getItemCount(): Int {
        return listModules.size
    }
}

internal interface IMyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}