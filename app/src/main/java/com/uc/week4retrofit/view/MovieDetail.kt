package com.uc.week4retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.uc.week4retrofit.adapter.ProductionCompanyAdapter
import com.uc.week4retrofit.adapter.GenreAdapter
import com.uc.week4retrofit.adapter.ProductionCountryAdapter
import com.uc.week4retrofit.databinding.ActivityMovieDetailBinding
import com.uc.week4retrofit.helper.Const
import com.uc.week4retrofit.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetail : AppCompatActivity() {

    private lateinit var binding : ActivityMovieDetailBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var genreAdapter : GenreAdapter
    private lateinit var productionCountryAdapter: ProductionCountryAdapter
    private lateinit var productionCompanyAdapter : ProductionCompanyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieId = intent.getIntExtra("movie_id",0)
        Toast.makeText(applicationContext, "Movie ID : ${movieId}", Toast.LENGTH_SHORT).show()

        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getMovieDetails(movieId,Const.API_KEY)

        binding.progressBar.visibility = View.VISIBLE

        viewModel.movieDetails.observe(this) { response ->

            binding.tvTitleMovieDetail.apply {
                text = response.title

                Glide.with(applicationContext)
                    .load(Const.IMG_URL + response.backdrop_path)
                    .into(binding.imgPosterMovieDetail)
            }

            binding.tvOverview.apply{
                text=response.overview
            }

            binding.rvGenre.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            genreAdapter = GenreAdapter(response.genres)
            binding.rvGenre.adapter = genreAdapter

            binding.rvCompanyProduction.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            productionCompanyAdapter = ProductionCompanyAdapter(response.production_companies)
            binding.rvCompanyProduction.adapter = productionCompanyAdapter

            binding.rvCountryProduction.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false)
            productionCountryAdapter = ProductionCountryAdapter(response.production_countries)
            binding.rvCountryProduction.adapter = productionCountryAdapter

            binding.progressBar.visibility = View.INVISIBLE

        }
    }
}