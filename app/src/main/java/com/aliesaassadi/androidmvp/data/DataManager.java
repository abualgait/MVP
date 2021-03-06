package com.aliesaassadi.androidmvp.data;

import com.aliesaassadi.androidmvp.data.log.source.LogDataSource;
import com.aliesaassadi.androidmvp.data.log.source.LogRepository;
import com.aliesaassadi.androidmvp.data.movie.Book;
import com.aliesaassadi.androidmvp.data.movie.source.BooksRepository;
import com.aliesaassadi.androidmvp.data.movie.source.MovieDataSource;
import com.aliesaassadi.androidmvp.data.movie.source.MoviesRepository;
import com.aliesaassadi.androidmvp.data.movie.source.local.MovieCacheDataSource;
import com.aliesaassadi.androidmvp.data.movie.source.local.MovieLocalDataSource;
import com.aliesaassadi.androidmvp.data.movie.source.remote.BooksRemoteDataSource;
import com.aliesaassadi.androidmvp.data.movie.source.remote.MovieRemoteDataSource;
import com.aliesaassadi.androidmvp.data.movie.source.remote.services.BookApi;
import com.aliesaassadi.androidmvp.data.movie.source.remote.services.BookService;
import com.aliesaassadi.androidmvp.data.movie.source.remote.services.MovieApi;
import com.aliesaassadi.androidmvp.data.movie.source.remote.services.MovieService;
import com.preference.PowerPreference;
import com.preference.Preference;

/**
 * Created by Ali Esa Assadi on 26/03/2018.
 */

public class DataManager {

    private static DataManager sInstance;

    private DataManager() {
        // This class is not publicly instantiable
    }

    public static synchronized DataManager getInstance() {
        if (sInstance == null) {
            sInstance = new DataManager();
        }
        return sInstance;
    }

    public Preference getDefaultPreference() {
        return PowerPreference.getDefaultFile();
    }

    public Preference getUserPreference() {
        return PowerPreference.getFileByName("UserPreference");
    }

    public LogRepository getLogRepository(LogDataSource logLocalDataSource) {
        return LogRepository.getInstance(logLocalDataSource);
    }

    public MovieApi getMovieApi() {
        return MovieService.getInstance().getMovieApi();
    }


    public MoviesRepository getMovieRepository(MovieRemoteDataSource movieRemote,
                                               MovieLocalDataSource movieLocal,
                                               MovieCacheDataSource movieCache) {
        return MoviesRepository.getInstance(movieRemote, movieLocal, movieCache);
    }

    public BookApi getBookApi() {
        return BookService.getInstance().getmBookApi();
    }

    public BooksRepository getBookRepository(BooksRemoteDataSource booksRemoteDataSource) {
        return BooksRepository.getInstance(booksRemoteDataSource);
    }


}
