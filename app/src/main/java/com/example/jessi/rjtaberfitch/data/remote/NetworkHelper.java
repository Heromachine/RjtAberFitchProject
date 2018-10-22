package com.example.jessi.rjtaberfitch.data.remote;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jessi.rjtaberfitch.AppController;
import com.example.jessi.rjtaberfitch.data.IDataManager;
import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;
import com.example.jessi.rjtaberfitch.data.models.ContentObject;
import com.example.jessi.rjtaberfitch.data.models.PromoCardModel;
import com.example.jessi.rjtaberfitch.data.models.robopojo.AFPojo;
import com.example.jessi.rjtaberfitch.data.remote.retrofit.ApiService;
import com.example.jessi.rjtaberfitch.data.remote.retrofit.RetrofitInstance;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkHelper implements INetworkHelper {
    private static final String TAG = "NetworkHelper";

    @Override
    public void retrofitCall(final IDataManager.OnResponseListener listener) {
        Log.d(TAG, "retrofitCall: ");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,
                "https://www.abercrombie.com/anf/nativeapp/qa/codetest/codeTest_exploreData.json",
                null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //START FOR LOOP 1==========================================================
                        AllPromoCardsModel allPromoCardsModel = new AllPromoCardsModel();
                        List<PromoCardModel> promoCardModelList = new ArrayList<>();

                       // Log.d(TAG, "onResponse: RESPONSE SIZE: " + response.length());
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                PromoCardModel promoCardModel = new PromoCardModel();
                                promoCardModel.setTitle(jsonObject.get("title").toString());
                                promoCardModel.setBackgroundImage(jsonObject.get("backgroundImage").toString());

                                if(!jsonObject.isNull("promoMessage")){

                                    promoCardModel.setPromoMessage(jsonObject.get("promoMessage").toString());
                                }
                                else
                                {
                                    promoCardModel.setPromoMessage("");
                                }

                                if(!jsonObject.isNull("topDescription"))
                                {
                                    promoCardModel.setTopDescription(jsonObject.get("topDescription").toString());
                                }
                                else{
                                    promoCardModel.setTopDescription("");
                                }


                                if(!jsonObject.isNull("bottomDescription")) {
                                    promoCardModel.setBottomDescription(jsonObject.get("bottomDescription").toString());
                                }
                                else
                                {
                                    promoCardModel.setBottomDescription("");
                                }


                                if(!jsonObject.isNull("content")){
                                    JSONArray jsonArrayContentObject = jsonObject.getJSONArray("content");
                                    List<ContentObject> contentObjectList = new ArrayList<>();
                                    for(int j = 0; j < jsonArrayContentObject.length(); j++){
                                        ContentObject contentObject = new ContentObject();
                                        contentObject.setTitle(jsonArrayContentObject.getJSONObject(j).get("title").toString());
                                        contentObject.setTarget(jsonArrayContentObject.getJSONObject(j).get("target").toString());
                                        contentObjectList.add(contentObject);
                                        promoCardModel.setContentObjects(contentObjectList);
                                    }
                                }

                                Log.d(TAG, "onResponse: PROMO CARD MODEL: " + promoCardModel.getTitle());
                                promoCardModelList.add(promoCardModel);

                            } catch (JSONException e) {
                                Log.d(TAG, "onResponse: ERROR " + e.getMessage());
                                e.printStackTrace();
                            }
                        }
                        //END FOR LOOP 1============================================================
                        allPromoCardsModel.setPromoCardModelList(promoCardModelList);
//                        Log.d(TAG, "onResponse: ===============================" + allPromoCardsModel.getPromoCardModelList().get(0).getTitle());
                        listener.callRetrofitNote(allPromoCardsModel);
                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: +" + error.getMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}


//    @Override
//    public void retrofitCall(final IDataManager.OnResponseListener listener) {
//
//        Log.d(TAG, "retrofitCall: ");
//        ApiService apiService = RetrofitInstance.getRetrofitInstance()
//                .create(ApiService.class);
//        final Call<ArrayList<AFPojo>> afPojoCall = apiService.getAllPromoCardsPojo();
//        Log.d(TAG, "retrofitCall: " + afPojoCall.toString());
//        afPojoCall.enqueue(new Callback<ArrayList<AFPojo>>() {
//            @Override
//            public void onResponse(Call<ArrayList<AFPojo>> call, Response<ArrayList<AFPojo>> response) {
//                Log.d(TAG, "onResponse: " + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<AFPojo>> call, Throwable t) {
//
//            }
//        });
//    }
//}







//    @Override
//    public void retrofitCall(final IDataManager.OnResponseListener listener) {
//        Log.d(TAG, "retrofitCall: ");
//        ApiService apiService = RetrofitInstance.getRetrofitInstance()
//                .create(ApiService.class);
//        Call<List<PromoCardModel>> promoCardModelCall = apiService.getPromoCards();
//        promoCardModelCall.enqueue(new Callback<List<PromoCardModel>>() {
//            @Override
//            public void onResponse(Call<List<PromoCardModel>> call, Response<List<PromoCardModel>> response) {
//
//                Log.d(TAG, "onResponse: " + response.isSuccessful());
//                AllPromoCardsModel allPromoCardsModel = new AllPromoCardsModel();
//                        allPromoCardsModel.setPromoCardModelList(response.body());
//
//                for(int i = 0; i <  allPromoCardsModel.getPromoCardModelList().size(); i++)
//                {
//                    PromoCardModel promoCardModel = new PromoCardModel();
//
//                    promoCardModel.setTitle(response.body().get(i).getTitle());
//                    for(int j = 0; i< response.body().get(i).getContentObjects().size(); j ++)
//                    {
//                        promoCardModel.getContentObjects().add(response.body().get(i).getContentObjects().get(j));
//                        promoCardModel.getContentObjects().get(j).getTarget();
//                        promoCardModel.getContentObjects().get(j).getElementType();
//                    }
//                    promoCardModel.setPromoMessage(response.body().get(i).getPromoMessage());
//                    promoCardModel.setTopDescription(response.body().get(i).getTopDescription());
//                    promoCardModel.setBottomDescription(response.body().get(i).getBottomDescription());
//
//                    allPromoCardsModel.getPromoCardModelList().add(promoCardModel);
//
//                    Log.d(TAG, "onResponse: ALLPROMOCARDS TITLES " + allPromoCardsModel.getPromoCardModelList().get(i).getTitle());
//                }
//                listener.callRetrofitNote(allPromoCardsModel);
//            }
//
//            @Override
//            public void onFailure(Call<List<PromoCardModel>> call, Throwable t) {
//                Log.d(TAG, "onFailure: " +  t.getMessage());
//            }
//        });
//    }
//}




