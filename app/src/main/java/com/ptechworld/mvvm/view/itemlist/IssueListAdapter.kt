package com.ptechworld.mvvm.view.itemlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ptechworld.mvvm.data.local.entity.Issue
import com.ptechworld.mvvm.data.local.entity.Repo
import com.ptechworld.mvvm.databinding.ItemListContentBinding
import com.ptechworld.mvvm.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.item_list_content.view.*

class IssueListAdapter(private val listener: IssueSelectedListener) : ListAdapter<Issue, RecyclerView.ViewHolder>(PlantDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(ItemListContentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val issue = getItem(position)
        (holder as ViewHolder).bind(issue, listener)
    }

    inner class ViewHolder(private val binding: ItemListContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Issue, listener: IssueSelectedListener) {
            binding.issue = item
            binding.clickListener = View.OnClickListener { view ->
                listener.onSelect(item)
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Issue>() {

    override fun areItemsTheSame(oldItem: Issue, newItem: Issue): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Issue, newItem: Issue): Boolean {
        return oldItem == newItem
    }
}