package com.example.jessi.rjtaberfitch.data.models;

import java.util.List;

public class AllPromoCardsModel {

    List<PromoCardModel> promoCardModelList;

    public AllPromoCardsModel() {
    }

    public AllPromoCardsModel(List<PromoCardModel> promoCardModelList) {
        this.promoCardModelList = promoCardModelList;
    }

    public List<PromoCardModel> getPromoCardModelList() {
        return promoCardModelList;
    }

    public void setPromoCardModelList(List<PromoCardModel> promoCardModelList) {
        this.promoCardModelList = promoCardModelList;
    }
}
