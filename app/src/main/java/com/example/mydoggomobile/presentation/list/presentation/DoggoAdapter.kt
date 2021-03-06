package com.example.mydoggomobile.presentation.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydoggomobile.R
import com.example.mydoggomobile.presentation.list.api.DoggoListResponse

class DoggoAdapter(private var dataSet: List<DoggoListResponse>, var listener: ((DoggoListResponse) -> Unit)? = null) : RecyclerView.Adapter<DoggoAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val doggoImage: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.doggo_name)
            doggoImage = view.findViewById(R.id.doggo_image)
        }
    }


    fun updateList(list: List<DoggoListResponse>){
        dataSet = list
        notifyDataSetChanged()

    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.doggo_item, viewGroup, false)

        return ViewHolder(
            view
        )
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val doggo : DoggoListResponse = dataSet[position]
        viewHolder.textView.text = doggo.name
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(doggo) }
        Glide.with(viewHolder.itemView.context)
            .load(doggo.image.url)
            .centerCrop()
            .into(viewHolder.doggoImage)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
