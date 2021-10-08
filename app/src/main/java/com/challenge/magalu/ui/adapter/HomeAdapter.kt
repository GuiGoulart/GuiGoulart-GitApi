package com.challenge.magalu.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.challenge.magalu.R
import com.challenge.magalu.data.model.RepositoryResponse
import com.challenge.magalu.ui.listener.HomeAdapterListener
import de.hdodenhof.circleimageview.CircleImageView

class HomeAdapter(
    private var context: Context,
    private var homeAdapterListener: HomeAdapterListener,
): PagedListAdapter<RepositoryResponse.Item, HomeAdapter.HomeViewHolder>(DataDifferntiator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_repository, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        bindViewHolder(holder, getItem(position))
    }

    @SuppressLint("SetTextI18n")
    private fun bindViewHolder(holder: HomeViewHolder, item: RepositoryResponse.Item?) {
        item?.let { items ->
            holder.listRepositoryTitle.text = items.owner.login
            holder.listRepositoryDescription.text = "${items.description.substring(0, item.description.length.div(2))}..."
            holder.listRepositoryForks.text = items.forks.toString()
            holder.listRepositoryStarts.text = items.stargazers_count.toString()

            Glide.with(context)
                .load(items.owner.avatar_url)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .into(holder.listRepositoryCircleImage)

            holder.listRepositoryUsername.text = items.name
            holder.listRepositoryNameComplet.text = items.full_name

            holder.listRepositoryConstraint.setOnClickListener {
                homeAdapterListener.clicable(items.owner.login, items.name)
            }
        }
    }

    object DataDifferntiator : DiffUtil.ItemCallback<RepositoryResponse.Item>() {

        override fun areItemsTheSame(oldItem: RepositoryResponse.Item, newItem: RepositoryResponse.Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RepositoryResponse.Item, newItem: RepositoryResponse.Item): Boolean {
            return oldItem == newItem
        }
    }

    class HomeViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val listRepositoryConstraint: ConstraintLayout = v.findViewById(R.id.listRepositoryConstraint)
        val listRepositoryTitle: AppCompatTextView = v.findViewById(R.id.listRepositoryTitle)
        val listRepositoryDescription: AppCompatTextView = v.findViewById(R.id.listRepositoryDescription)
        val listRepositoryForks: AppCompatTextView = v.findViewById(R.id.listRepositoryForks)
        val listRepositoryStarts: AppCompatTextView = v.findViewById(R.id.listRepositoryStarts)
        val listRepositoryCircleImage: CircleImageView = v.findViewById(R.id.listRepositoryCircleImage)
        val listRepositoryUsername: AppCompatTextView = v.findViewById(R.id.listRepositoryUsername)
        val listRepositoryNameComplet: AppCompatTextView = v.findViewById(R.id.listRepositoryNameComplet)
    }

}