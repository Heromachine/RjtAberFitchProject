package com.example.jessi.rjtaberfitch.ui;

import android.view.View;

import com.example.jessi.rjtaberfitch.data.DataManager;
import com.example.jessi.rjtaberfitch.data.IDataManager;
import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;
import com.example.jessi.rjtaberfitch.data.models.PromoCardModel;
import com.example.jessi.rjtaberfitch.ui.MainActivity;
import com.example.jessi.rjtaberfitch.ui.MainActivityContract;

public class MainActivityPresenter implements MainActivityContract.IPresenter, IDataManager.OnResponseListener{
    MainActivityContract.IView view;
    IDataManager dataManager;

    public MainActivityPresenter(MainActivity mainActivity) {
        view = mainActivity;
        dataManager = new DataManager();
        dataManager.retrofitCall(this);


    }

    @Override
    public void onButtonClicked(View view){
    }

    @Override
    public void callRetrofitNote(AllPromoCardsModel allPromoCardsModel) {
        view.initListAdapter(allPromoCardsModel);
    }
}
