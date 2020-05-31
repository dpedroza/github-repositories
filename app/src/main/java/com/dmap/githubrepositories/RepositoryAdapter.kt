package com.dmap.githubrepositories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repository.view.*

class RepositoryAdapter: RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    private val repositories = listOf("repo 1", "repo2", "repo 3")

    override fun getItemCount() = repositories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val context = parent.context
        val layout = R.layout.item_repository
        val view = LayoutInflater.from(context).inflate(layout, parent, false)
        return RepositoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val repository = repositories[position]
        holder.bind(repository)
    }

    class RepositoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bind(repository: String) {
            itemView.textView.text = repository
        }
    }

}

