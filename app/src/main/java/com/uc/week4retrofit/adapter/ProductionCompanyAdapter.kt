package com.uc.week4retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uc.week4retrofit.R
import com.uc.week4retrofit.databinding.GenreCollectionBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.model.ProductionCompany
import androidx.lifecycle.ViewModelProvider
import com.uc.week4retrofit.databinding.CompanyProductionCollectionBinding
import com.uc.week4retrofit.viewmodel.MoviesViewModel

class ProductionCompanyAdapter(private val dataSet: List<ProductionCompany>) :
    RecyclerView.Adapter<ProductionCompanyAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = CompanyProductionCollectionBinding.bind(itemView)
       // val cvProductionCompany = binding.cvProductionCompany

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
            .inflate(R.layout.company_production_collection, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Glide.with(viewHolder.itemView.context)
            .load(Const.IMG_URL + dataSet[position].logo_path)
            .into(viewHolder.binding.imgCompanyProduction)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}