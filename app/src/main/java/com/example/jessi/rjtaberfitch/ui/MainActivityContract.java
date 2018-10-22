package com.example.jessi.rjtaberfitch.ui;

import android.view.View;

import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;

public interface MainActivityContract {

    interface IView{
        void initListAdapter(AllPromoCardsModel allPromoCardsModel);
    }
    interface IPresenter{
        void onButtonClicked(View view);
    }

}
