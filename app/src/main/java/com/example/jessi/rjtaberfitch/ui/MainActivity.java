package com.example.jessi.rjtaberfitch.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jessi.rjtaberfitch.R;
import com.example.jessi.rjtaberfitch.data.models.AllPromoCardsModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActivityContract.IView {

    @BindView(R.id.iv_promotion)
    ImageView ivPromotion;
    @BindView(R.id.tv_top_description)
    TextView tvTopDescription;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_promo_message)
    TextView tvPromoMessage;
    @BindView(R.id.tv_bottom_description)
    TextView tvBottomDescription;
    @BindView(R.id.btn_content1)
    Button button;
    @BindView(R.id.btn_content2)
    Button button2;

    MainActivityContract.IPresenter presenter;
    private ListView listView;
    private AllPromoCardsModel allPromoCardsModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter promoCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainActivityPresenter(this);
    }

    @OnClick({R.id.btn_content1, R.id.btn_content2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_content1:
                break;
            case R.id.btn_content2:
                break;
        }
    }

    @Override
    public void initListAdapter(AllPromoCardsModel allPromoCardsModel) {
        recyclerView = findViewById(R.id.rv_promo_card);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        promoCardAdapter = new PromoCardAdapter(
                MainActivity.this,
                allPromoCardsModel.getPromoCardModelList());
        recyclerView.setAdapter(promoCardAdapter);

    }
}
