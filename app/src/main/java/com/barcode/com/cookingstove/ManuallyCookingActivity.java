package com.barcode.com.cookingstove;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ManuallyCookingActivity extends AppCompatActivity {
    Button addToCookListBtn,startcooking;
    EditText temp,time,name;
    ImageView back,home,exclimation;
    SharedPreferences sharedpreferences ;
    SharedPreferences.Editor editor;
    DBhandler db = new DBhandler(ManuallyCookingActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manually_cooking);
        sharedpreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        addToCookListBtn = (Button) findViewById(R.id.addToClBtn);
        temp = (EditText)findViewById(R.id.tempEditText);
        time = (EditText) findViewById(R.id.timeEditText);
        startcooking = (Button) findViewById(R.id.startCooking);

        back = (ImageView) findViewById(R.id.arrow);
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
                Toast.makeText(ManuallyCookingActivity.this,"Excliamtion Button Pressed",Toast.LENGTH_LONG).show();

            }
        });
        home.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ManuallyCookingActivity.this,"Home Button Pressed",Toast.LENGTH_LONG).show();

            }
        });



        addToCookListBtn.setOnClickListener(new Button.OnClickListener() {

//            LayoutInflater li = LayoutInflater.from(ManuallyCookingActivity.this);
//            View promptsView = li.inflate(R.layout.prompt, null);
//
//            @Override
            public void onClick(View view) {

                openDialog();
            }


        });

        startcooking.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Time timeObj = new Time();
//                timeObj.timeStove1= time.getText().toString();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String currentDateTimeString= sdf.format(c.getTime());

                if (utils.currentChola.equals("1"))
                {
                    editor.putString("c1",currentDateTimeString);
                    editor.putString("t1",time.getText().toString());

                }
                if (utils.currentChola.equals("2"))
                {
                    editor.putString("c2",currentDateTimeString);
                    editor.putString("t2",time.getText().toString());

                }
                if (utils.currentChola.equals("3"))
                {
                    editor.putString("c3",currentDateTimeString);
                    editor.putString("t3",time.getText().toString());

                }
                if (utils.currentChola.equals("4"))
                {
                    editor.putString("c4",currentDateTimeString);
                    editor.putString("t4",time.getText().toString());

                }
                editor.commit();
                Toast.makeText(ManuallyCookingActivity.this,"Startcokkng",Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(ManuallyCookingActivity.this, StoveActivity.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ManuallyCookingActivity.this.startActivity(myIntent);
            }
        });
    }
    private void openDialog(){
        LayoutInflater inflater = LayoutInflater.from(ManuallyCookingActivity.this);
        View subView = inflater.inflate(R.layout.prompt, null);

        name = (EditText) subView.findViewById(R.id.dialogEditText);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter name of your cook");

        builder.setView(subView);
        AlertDialog alertDialog = builder.create();

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // textInfo.setText(subEditText.getText().toString());

                int tempVal = Integer.parseInt(temp.getText().toString());
                int timeVal = Integer.parseInt(time.getText().toString());
                String nameVal = name.getText().toString();

                Food food = new Food();

                food.setTime(timeVal);
                food.setTemp(tempVal);
                food.setName(nameVal);
                db.addFood(food);
                Toast.makeText(ManuallyCookingActivity.this, temp.getText().toString()+" "+time.getText().toString()+" "+name.getText().toString(), Toast.LENGTH_LONG).show();//+" "+name.getText()


                Intent myIntent = new Intent(ManuallyCookingActivity.this, AutomaticallyCookListActivity.class);

                ManuallyCookingActivity.this.startActivity(myIntent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(ManuallyCookingActivity.this, "Cancel", Toast.LENGTH_LONG).show();
            }
        });

        builder.show();
    }
}
