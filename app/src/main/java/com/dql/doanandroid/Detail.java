package com.dql.doanandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dql.doanandroid.data.DatabaseHelper;
import com.dql.doanandroid.global.GetImageFromUrl;
import com.dql.doanandroid.model.Shop;

public class Detail extends AppCompatActivity {

    private Shop shop;
    private DatabaseHelper db;

    private ImageView detailImg;

    private TextView detailShopName, detailRate, detailCount,detailArticle,allMenu;
    private Button btnBestSeller, btnNonVeg, btnDrink, btnVeg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int shopId = Integer.parseInt(getIntent().getStringExtra("shopId"));
        db = new DatabaseHelper(this);
        shop = db.getShopById(shopId);

        getViewById();
        initWidget();
        Toast.makeText(this, shop.getShopName(), Toast.LENGTH_SHORT).show();
    }

    private void getViewById() {
        detailImg=findViewById(R.id.detailImg);
        detailShopName=findViewById(R.id.detailShopName);
        detailRate=findViewById(R.id.detailRate);
        detailCount=findViewById(R.id.detailCount);
        detailArticle=findViewById(R.id.detailArticle);

        allMenu=findViewById(R.id.allMenu);

        btnBestSeller=findViewById(R.id.btnBestSeller);
        btnNonVeg=findViewById(R.id.btnNonVeg);
        btnVeg=findViewById(R.id.btnVeg);
        btnDrink=findViewById(R.id.btnDrink);
    }

    private void initWidget() {
        new GetImageFromUrl(detailImg)
                .execute("https://images.foody.vn/res/"+shop.getShopImg());
        detailShopName.setText(shop.getShopName());
        detailArticle.setText(shop.getShopArticle());

    }
}