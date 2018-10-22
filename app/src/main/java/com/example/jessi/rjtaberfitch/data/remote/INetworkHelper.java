package com.example.jessi.rjtaberfitch.data.remote;

import com.example.jessi.rjtaberfitch.data.IDataManager;

public interface INetworkHelper {

    void retrofitCall(IDataManager.OnResponseListener listener);

}
