package com.example.jessi.rjtaberfitch.data;

import com.example.jessi.rjtaberfitch.data.remote.INetworkHelper;
import com.example.jessi.rjtaberfitch.data.remote.NetworkHelper;

public class DataManager implements IDataManager {

    INetworkHelper networkHelper;

    //Contructor used by Presenter
    public DataManager(){
        networkHelper = new NetworkHelper();
    }

    @Override //Give Listener to --> Network
    public void retrofitCall(OnResponseListener listener) {
        networkHelper.retrofitCall(listener);
    }

    //NOT USED...butwhy?
    @Override
    public void getRetrofitNote(OnResponseListener onResponseListener) {

    }


}
