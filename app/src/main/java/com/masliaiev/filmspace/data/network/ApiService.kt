package com.masliaiev.filmspace.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getPopularityMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAMS_LANGUAGE) lang: String,
        @Query(QUERY_PARAMS_SORT_BY) sorted: String = SORT_BY_POPULARITY,
        @Query(QUERY_PARAMS_MIN_VOTE_COUNT) minVoteCount: String = MIN_VOTE_COUNT,
        @Query(QUERY_PARAMS_PAGE) page: String

    )

    @GET("discover/movie")
    suspend fun getTopRatedMovies(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAMS_LANGUAGE) lang: String,
        @Query(QUERY_PARAMS_SORT_BY) sorted: String = SORT_BY_TOP_RATED,
        @Query(QUERY_PARAMS_MIN_VOTE_COUNT) minVoteCount: String = MIN_VOTE_COUNT,
        @Query(QUERY_PARAMS_PAGE) page: String

    )


    @GET("movie/{movieId}/videos")
    suspend fun getTrailers(
        @Path(PATH_PARAM_MOVIE_ID) movieId: String,
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY

    )


    @GET("search/movie")
    suspend fun searchMovie(
        @Query(QUERY_PARAM_API_KEY) apiKey: String = API_KEY,
        @Query(QUERY_PARAMS_LANGUAGE) lang: String,
        @Query(QUERY_PARAMS_SEARCH) query: String,
        @Query(QUERY_PARAMS_PAGE) page: String

    )


    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAMS_LANGUAGE = "language"
        private const val QUERY_PARAMS_SORT_BY = "sort_by"
        private const val QUERY_PARAMS_PAGE = "page"
        private const val QUERY_PARAMS_MIN_VOTE_COUNT = "vote_count.gte"
        private const val QUERY_PARAMS_SEARCH = "query"
        private const val PATH_PARAM_MOVIE_ID = "movieId"

        private const val API_KEY = "9f9d136877ade7608f32a571c18756be"
        private const val SORT_BY_POPULARITY = "popularity.desc"
        private const val SORT_BY_TOP_RATED = "vote_average.desc"
        private const val MIN_VOTE_COUNT = "1000"

    }
}