package com.example.jessi.rjtaberfitch.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jessi.rjtaberfitch.R;
import com.example.jessi.rjtaberfitch.data.models.PromoCardModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PromoCardAdapter extends RecyclerView.Adapter<PromoCardAdapter.MyViewHolder> {
    private static final String TAG = "PromoCardAdapter";
    private List<PromoCardModel> promoCardModelList;
    private Context context;

    public PromoCardAdapter(Context context, List<PromoCardModel> promoCardModelList) {
        this.context = context;
        this.promoCardModelList = promoCardModelList;
        Log.d(TAG, "PromoCardAdapter: PROMOCARD MODEL LIST SIZE = " + promoCardModelList.size());
        for(int i = 0; i < promoCardModelList.size();i++){
            Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getTitle());
            Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getBottomDescription());
            Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getBackgroundImage());
            Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getPromoMessage());
            Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getTopDescription());

            if(promoCardModelList.get(i).getContentObjects() != null)
            {
                for(int j = 0; j < promoCardModelList.get(i).getContentObjects().size(); j++){
                    Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getContentObjects().get(j).getTitle());
                    Log.d(TAG, "PromoCardAdapter: " + promoCardModelList.get(i).getContentObjects().get(j).getTarget());
                }

            }

            Log.d(TAG, i + "]  PromoCardAdapter: =====================================================================================");
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View view = inflater.inflate(R.layout.cardview_promoitem, viewGroup, false);
        PromoCardAdapter.MyViewHolder myViewHolder = new PromoCardAdapter.MyViewHolder(view, this.context, this.promoCardModelList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int pos) {
        myViewHolder.tvTitle.setText(this.promoCardModelList.get(pos).getTitle());

        Picasso.get().load(promoCardModelList.get(pos).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(myViewHolder.ivPromoImage);


        if(this.promoCardModelList.get(pos).getContentObjects() == null)
        {

            myViewHolder.btnContent1.setVisibility(View.GONE);
            myViewHolder.btnContent2.setVisibility(View.GONE);
        }
        else if (this.promoCardModelList.get(pos).getContentObjects().size() == 1)
        {
            myViewHolder.btnContent1.setVisibility(View.VISIBLE);
            myViewHolder.btnContent1.setText(
                    this.promoCardModelList
                            .get(pos)
                            .getContentObjects()
                            .get(0)
                            .getTitle());
            myViewHolder.btnContent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(promoCardModelList.get(pos).getContentObjects().get(0).getTarget()));
                    context.startActivity(intent);
                }
            });
            myViewHolder.btnContent2.setVisibility(View.GONE);
        }
        else if(this.promoCardModelList.get(pos).getContentObjects().size() == 2){

            myViewHolder.btnContent1.setVisibility(View.VISIBLE);
            myViewHolder.btnContent1.setText(
                    this.promoCardModelList
                            .get(pos)
                            .getContentObjects()
                            .get(0)
                            .getTitle());
            myViewHolder.btnContent1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(promoCardModelList.get(pos).getContentObjects().get(0).getTarget()));
                    context.startActivity(intent);
                }
            });
            myViewHolder.btnContent2.setVisibility(View.VISIBLE);
            myViewHolder.btnContent2.setText
                    (this.promoCardModelList
                            .get(pos)
                            .getContentObjects()
                            .get(1)
                            .getTitle());
            myViewHolder.btnContent2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(promoCardModelList.get(pos).getContentObjects().get(1).getTarget()));
                    context.startActivity(intent);
                }
            });
        }


        myViewHolder.tvPromoMessage.setText(this.promoCardModelList.get(pos).getTitle());
        myViewHolder.tvTopDescription.setText(this.promoCardModelList.get(pos).getTopDescription());
        myViewHolder.tvBottomDescription.setText(this.promoCardModelList.get(pos).getBottomDescription());
    }

    @Override
    public int getItemCount() {
        return promoCardModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView ivPromoImage;
        Button btnContent1;
        Button btnContent2;
        TextView tvPromoMessage;
        TextView tvTopDescription;
        TextView tvBottomDescription;

        List<PromoCardModel> promoCardModelList;
        Context context;

        public MyViewHolder(@NonNull View itemView,
                            Context context,
                            List<PromoCardModel>promoCardModelList ) {
            super(itemView);

            this.context = context;
            this.promoCardModelList = promoCardModelList;

            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.ivPromoImage = itemView.findViewById(R.id.iv_promotion);
            this.btnContent1 = itemView.findViewById(R.id.btn_content1);
            this.btnContent2 = itemView.findViewById(R.id.btn_content2);
            this.tvPromoMessage = itemView.findViewById(R.id.tv_promo_message);
            this.tvTopDescription = itemView.findViewById(R.id.tv_top_description);
            this.tvBottomDescription = itemView.findViewById(R.id.tv_bottom_description);


        }
    }
}
