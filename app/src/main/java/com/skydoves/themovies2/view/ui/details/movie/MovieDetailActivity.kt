/*
 * Designed and developed by 2019 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.themovies2.view.ui.details.movie

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.skydoves.themovies2.R
import com.skydoves.themovies2.compose.ViewModelActivity
import com.skydoves.themovies2.databinding.ActivityMovieDetailBinding
import com.skydoves.themovies2.models.entity.Movie
import com.skydoves.themovies2.view.adapter.ReviewListAdapter
import com.skydoves.themovies2.view.adapter.VideoListAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MovieDetailActivity : ViewModelActivity() {

  private val binding: ActivityMovieDetailBinding by binding(R.layout.activity_movie_detail)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val intentMovie: Movie? = intent.getParcelableExtra(movieId) as Movie?
    with(binding) {
      activity = this@MovieDetailActivity
      lifecycleOwner = this@MovieDetailActivity
      getViewModel(null, MovieDetailViewModel::class).apply {
      //getViewModel("MovieDetailViewModel").apply {

        if (intentMovie != null) {
              postMovieId(intentMovie.id)
        }
      }.also { viewModel = it }
      movie = intentMovie
      videoListAdapter = VideoListAdapter()
      reviewListAdapter = ReviewListAdapter()
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item?.itemId == android.R.id.home) onBackPressed()
    return false
  }

  companion object {
    private const val movieId = "movie"
    fun startActivityModel(context: Context?, movie: Movie) {
      if (context is Activity) {
        context.startActivity(
          Intent(context, MovieDetailActivity::class.java).putExtra(movieId, movie))
      }
    }
  }
}
