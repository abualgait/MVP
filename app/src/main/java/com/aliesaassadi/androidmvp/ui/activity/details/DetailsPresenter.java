package com.aliesaassadi.androidmvp.ui.activity.details;

import com.aliesaassadi.androidmvp.data.movie.Movie;
import com.aliesaassadi.androidmvp.ui.activity.base.BasePresenter;


/**
 * Created by Ali Esa Assadi on 12/03/2018.
 */
public class DetailsPresenter extends BasePresenter<DetailsView> {

    public DetailsPresenter(DetailsView view) {
        super(view);
    }

    public void onMovieReceived(Movie movie) {
        if (movie != null) {
            baseview.showMovieDetails(movie);
        } else {
            baseview.showDataUnavailableMessage();
        }
    }
}
