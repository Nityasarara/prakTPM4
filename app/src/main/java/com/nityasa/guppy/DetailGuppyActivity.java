package com.nityasa.guppy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailGuppyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageView img           = findViewById(R.id.image);
        TextView nameTxt        = findViewById(R.id.name);
        TextView priceTxt       = findViewById(R.id.price);
        TextView descriptionTxt = findViewById(R.id.description);

        Bundle extras = getIntent().getExtras();

        String image        = extras.getString("IMAGE_KEY");
        String name         = extras.getString("NAME_KEY");
        String price        = extras.getString("PRICE_KEY");
        String description  = extras.getString("DESCRIPTION_KEY");

        setTitle("Detail "+ name);

        img.setImageURI(Uri.parse(image));
        Glide.with(this)
                .load(image)
                .into(img);

        nameTxt.setText(name);
        priceTxt.setText(price);
        descriptionTxt.setText(description);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
