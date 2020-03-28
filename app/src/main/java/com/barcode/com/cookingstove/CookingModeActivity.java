package com.barcode.com.cookingstove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CookingModeActivity extends AppCompatActivity{
    Button manualBtn;
    Button autoBtn;
    ImageView back,home,exclimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking_mode);
        back = (ImageView) findViewById(R.id.arrow);
        manualBtn = (Button) findViewById(R.id.manualBtn);
        autoBtn = (Button) findViewById(R.id.autoBtn);

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        home = (ImageView) findViewById(R.id.home);
        exclimation = (ImageView) findViewById(R.id.exclimation);
        exclimation.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CookingModeActivity.this,"Exclimation Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CookingModeActivity.this,"Home Button Pressed",Toast.LENGTH_LONG).show();

            }
        });



        autoBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CookingModeActivity.this, AutomaticallyCookListActivity.class);

                CookingModeActivity.this.startActivity(myIntent);
            }
        });
        manualBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CookingModeActivity.this, ManuallyCookingActivity.class);

                CookingModeActivity.this.startActivity(myIntent);
            }
        });
    }
}
