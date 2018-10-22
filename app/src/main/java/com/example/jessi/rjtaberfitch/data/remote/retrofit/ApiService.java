package com.example.jessi.rjtaberfitch.data.remote.retrofit;

import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;
import com.example.jessi.rjtaberfitch.data.models.PromoCardModel;
import com.example.jessi.rjtaberfitch.data.models.robopojo.AFPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
//https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json
    @GET("codeTest_exploreData.json")
    Call<List<PromoCardModel>> getPromoCards();

    //https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json
    @GET("codeTest_exploreData.json")
    Call<AllPromoCardsModel> getAllPromoCards();

    @GET("codeTest_exploreData.json")
    Call<ArrayList<AFPojo>> getAllPromoCardsPojo();
}
