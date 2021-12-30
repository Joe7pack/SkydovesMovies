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

package com.skydoves.themovies2.di

//import org.koin.androidx.viewmodel.dsl. .viewModel  .viewModel
import com.skydoves.themovies2.view.ui.details.movie.MovieDetailViewModel
import com.skydoves.themovies2.view.ui.details.person.PersonDetailViewModel
import com.skydoves.themovies2.view.ui.details.tv.TvDetailViewModel
import com.skydoves.themovies2.view.ui.main.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.dsl.module

val viewModelModule = module {
  viewModel { MainActivityViewModel(get(), get()) }
  viewModel { MovieDetailViewModel(get()) }
  viewModel { TvDetailViewModel(get()) }
  viewModel { PersonDetailViewModel(get()) }
}
