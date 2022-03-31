package com.masliaiev.filmspace.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.masliaiev.filmspace.domain.entity.Account
import com.masliaiev.filmspace.domain.entity.requests.MarkAsFavouriteRequest
import com.masliaiev.filmspace.domain.entity.responses.MarkAsFavouriteResponse
import com.masliaiev.filmspace.domain.entity.Movie
import com.masliaiev.filmspace.domain.entity.requests.AddToWatchlistRequest
import com.masliaiev.filmspace.domain.entity.responses.AddToWatchlistResponse

interface MovieRepository {

    //Authentication



    //AccountDto

    suspend fun getAccountDetails(sessionId: String): Account

    fun getFavouriteMoviesList(sessionId: String, accountId: Int): LiveData<List<Movie>>

    fun getRatedMoviesList(sessionId: String, accountId: Int): LiveData<List<Movie>>

    fun getMoviesWatchlist(sessionId: String, accountId: Int): LiveData<List<Movie>>

    suspend fun markAsFavourite(markAsFavouriteRequest: MarkAsFavouriteRequest): MarkAsFavouriteResponse //header "application/json;charset=utf-8"

    suspend fun addToWatchlist(addToWatchlistRequest: AddToWatchlistRequest): AddToWatchlistResponse  //header "application/json;charset=utf-8"







    fun getSearchedMovieList(): LiveData<List<Movie>>

    suspend fun addFavouriteMovie(movie: Movie)

    suspend fun addSearchedMovie(movie: Movie)

    suspend fun deleteFavouriteMovie(id: Int)

    suspend fun deleteAllSearchedMovies()

    fun loadPopularityMovies(): LiveData<PagingData<Movie>>

    fun loadTopRatedMovies(): LiveData<PagingData<Movie>>

    fun searchMovies(lang: String, query: String): LiveData<PagingData<Movie>>

}