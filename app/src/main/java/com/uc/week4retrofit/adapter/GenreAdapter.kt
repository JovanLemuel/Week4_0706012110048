package com.uc.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uc.week4retrofit.R
import com.uc.week4retrofit.databinding.GenreCollectionBinding
import com.uc.week4retrofit.model.Genre
import com.uc.week4retrofit.view.MovieDetail

class GenreAdapter(private val dataGenre: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = GenreCollectionBinding.bind(itemView)
        val tvGenre = binding.tvGenre
        val cvGenre = binding.cvGenre

//        init {
//            // Define click listener for the ViewHolder's View.
//            tvTitleNowPlaying = view.findViewById(R.id.tv_title_now_playing)
//            tvReleasedNowPlaying = view.findViewById(R.id.tv_released_now_playing)
//        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.genre_collection, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvGenre.text = dataGenre[position].name
       // viewHolder.tvReleasedNowPlaying.text = dataSet[position].release_date
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataGenre.size

}