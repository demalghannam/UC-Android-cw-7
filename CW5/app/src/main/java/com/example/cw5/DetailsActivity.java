package com.example.cw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView NameText = findViewById(R.id.deText);
        TextView PriceText = findViewById(R.id.deText2);
        ImageView lapimg = findViewById(R.id.Dimage);


        Bundle bundle = getIntent().getExtras();

        Items sentlap =  (Items)bundle.getSerializable("laptop");

        NameText.setText(sentlap.getItemName());
        PriceText.setText(sentlap.getItemPrice()+"");
        //lapimg.setImageResource(sentlap.getItemImage());

        Picasso.with(this).load((sentlap.getItemImage())).into(lapimg);

    }
}