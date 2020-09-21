package eif.viko.lt.auto.Adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import eif.viko.lt.auto.Models.Auto
import eif.viko.lt.auto.R
import kotlinx.android.synthetic.main.auto_item.view.*

class AutoListAdapter(private val interaction: Interaction? = null) :
    ListAdapter<Auto, AutoListAdapter.AutoViewHolder>(AutoDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AutoViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.auto_item, parent, false), interaction
    )

    override fun onBindViewHolder(holder: AutoViewHolder, position: Int) =
        holder.bind(getItem(position))

    fun swapData(data: List<Auto>) {
        submitList(data.toMutableList())
    }

    inner class AutoViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return

            val clicked = getItem(adapterPosition)
        }

        fun bind(item: Auto) = with(itemView) {
            // TODO: Bind the data with View
            title_auto.text = item.title
            details_auto.text = item.details
            Picasso.get().load(item.imageURL).into(image_auto);

        }
    }

    interface Interaction {

    }

    private class AutoDC : DiffUtil.ItemCallback<Auto>() {
        override fun areItemsTheSame(
            oldItem: Auto,
            newItem: Auto
        ) = oldItem.details == newItem.details

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Auto,
            newItem: Auto
        ) = oldItem == newItem
    }
}