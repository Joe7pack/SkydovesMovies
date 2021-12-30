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

package com.skydoves.themovies2.view.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.skydoves.themovies2.R
import com.skydoves.themovies2.compose.ViewModelFragment
import com.skydoves.themovies2.databinding.MainFragmentMovieBinding
import com.skydoves.themovies2.view.adapter.MovieListAdapter
import org.koin.androidx.viewmodel.ext.android.getViewModel

//import org.koin.android.viewmodel.ext.android.getViewModel

class MovieListFragment : ViewModelFragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return binding<MainFragmentMovieBinding>(inflater, R.layout.main_fragment_movie,
      container).apply {
      viewModel = getViewModel<MainActivityViewModel>().apply { postMoviePage(1) }
      //viewModel = getViewModel().apply { postMoviePage(1) }
      lifecycleOwner = this@MovieListFragment
      adapter = MovieListAdapter()
    }.root
  }
}
