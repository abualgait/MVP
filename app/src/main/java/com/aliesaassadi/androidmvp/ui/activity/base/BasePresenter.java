package com.aliesaassadi.androidmvp.ui.activity.base;

/**
 * Created by Ali Esa Assadi on 26/03/2018.
 */
public abstract class BasePresenter<View extends BaseView> {

    protected View baseview;

    protected BasePresenter(View view) {
        this.baseview = view;
    }

    void destroyView() {
        //avoid memory leak
        baseview = null;
    }
}
