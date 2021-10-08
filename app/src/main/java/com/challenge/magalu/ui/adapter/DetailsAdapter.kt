package com.challenge.magalu.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.challenge.magalu.R
import com.challenge.magalu.data.model.RepositoryPullsResponse
import com.challenge.magalu.ui.listener.DetailsAdapterListener
import com.challenge.magalu.util.Util
import de.hdodenhof.circleimageview.CircleImageView

class DetailsAdapter(var context: Context, var detailsAdapterListener: DetailsAdapterListener) : RecyclerView.Adapter<DetailsAdapter.DetailsAdapterViewHolder>() {

    private var listAdapter: List<RepositoryPullsResponse> = emptyList()

    fun setList(list: List<RepositoryPullsResponse>){
        listAdapter = emptyList()
        listAdapter = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsAdapterViewHolder {
        return DetailsAdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_repository_details, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DetailsAdapterViewHolder, position: Int) {
        bindViewHolder(holder, listAdapter[position])
    }

    @SuppressLint("SetTextI18n")
    private fun bindViewHolder(holder: DetailsAdapterViewHolder, item: RepositoryPullsResponse?) {
        item?.let { items ->
            holder.listRepositoryDetailsTitle.text = items.title
            holder.listRepositoryDetailsDescription.text = items.head?.repo?.description
            holder.listRepositoryDetailsDate.text = String.format(context.getString(R.string.date_list_details),
                items.created_at?.let { Util.convertDateFormat(it, "yyyy-MM-dd'T'HH:mm:ss'Z'","dd/MM/yyyy\nHH:mm") })

            Glide.with(context)
                .load(items.head?.repo?.owner?.avatar_url)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .into(holder.listRepositoryDetailsCircleImage)

            holder.listRepositoryDetailsUsername.text = items.head?.repo?.name
            holder.listRepositoryDetailsNameComplet.text = items.head?.repo?.full_name

            holder.listRepositoryDetailsConstraintLayout.setOnClickListener {
                items.html_url?.let { html -> detailsAdapterListener.clicable(html) }
            }
        }
    }

    override fun getItemCount(): Int {
        return if (listAdapter == null) {
            0
        } else listAdapter.size
    }


    class DetailsAdapterViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val listRepositoryDetailsConstraintLayout: ConstraintLayout = v.findViewById(R.id.listRepositoryDetailsConstraintLayout)
        val listRepositoryDetailsTitle: AppCompatTextView = v.findViewById(R.id.listRepositoryDetailsTitle)
        val listRepositoryDetailsDescription: AppCompatTextView = v.findViewById(R.id.listRepositoryDetailsDescription)
        val listRepositoryDetailsDate: AppCompatTextView = v.findViewById(R.id.listRepositoryDetailsDate)
        val listRepositoryDetailsCircleImage: CircleImageView = v.findViewById(R.id.listRepositoryDetailsCircleImage)
        val listRepositoryDetailsUsername: AppCompatTextView = v.findViewById(R.id.listRepositoryDetailsUsername)
        val listRepositoryDetailsNameComplet: AppCompatTextView = v.findViewById(R.id.listRepositoryDetailsNameComplet)
    }

}