package com.example.jessi.rjtaberfitch.data;

import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;
import com.example.jessi.rjtaberfitch.data.models.PromoCardModel;
import com.example.jessi.rjtaberfitch.data.remote.INetworkHelper;

public interface IDataManager extends INetworkHelper {

    //USED BY PRESENTER
    void getRetrofitNote(OnResponseListener onResponseListener);


    interface OnResponseListener{
        void callRetrofitNote(AllPromoCardsModel allPromoCardsModel);
    }
}
